package com.gre.todo.web.util;

import com.gre.todo.dto.BuildingDto;
import com.gre.todo.dto.Lookup;
import com.gre.todo.dto.PersonDto;
import com.gre.todo.dto.ProjectProgressDto;
import com.gre.todo.services.ProjectProgressService;
import com.gre.todo.services.ProjectProgressServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.Model;

import java.util.List;

/**
 * Created by Jan_R on 15/05/2017.
 */
public class HelperUtil {

    private static final Logger logger = LogManager.getLogger(HelperUtil.class);

    public static DataView<PersonDto> getAllPersonsDataView() {

        DataView<PersonDto> dataView = null;
        try {
            ProjectProgressService service = new ProjectProgressServiceImpl();
            logger.info("calling service method to get all persons");
            List<PersonDto> personDtoList = service.findAllPersons();
            ListDataProvider<PersonDto> listDataProvider = new ListDataProvider<PersonDto>(personDtoList);
            dataView = new DataView<PersonDto>("rows", listDataProvider) {
                @Override
                protected void populateItem(final Item<PersonDto> item) {
                    PersonDto personDto = item.getModelObject();
                    RepeatingView repeatingView = new RepeatingView("dataRow");
                    repeatingView.add(new Label(repeatingView.newChildId(), personDto.getFirstName()));
                    repeatingView.add(new Label(repeatingView.newChildId(), personDto.getLastName()));
                    repeatingView.add(new Label(repeatingView.newChildId(), personDto.getEmail()));
                    item.add(repeatingView);
                    item.add(AttributeModifier.replace("class", new AbstractReadOnlyModel<String>() {
                        private static final long serialVersionUID = 1L;

                        @Override
                        public String getObject() {
                            return (item.getIndex() % 2 == 1) ? "even" : "odd";
                        }
                    }));
                }
            };

        } catch (Exception ex) {
            logger.error("exception while getting persons data");
        }

        return dataView;
    }


    /**
     * this method call service methods to get project progress or project's todos
     *
     * @param projectId
     * @param buildingId
     * @param personId
     */
    public static DataView<ProjectProgressDto> getAllProjects(Long projectId, Long buildingId, Long personId) {

        ProjectProgressService service = new ProjectProgressServiceImpl();
        logger.info("calling service method to filter projects against");
        List<ProjectProgressDto> ProjectProgressDtoResultList = service.findProjectProgressBy(projectId, buildingId, personId);

        ListDataProvider<ProjectProgressDto> listDataProvider = new ListDataProvider<ProjectProgressDto>(ProjectProgressDtoResultList);
        DataView<ProjectProgressDto> dataView = new DataView<ProjectProgressDto>("rows", listDataProvider) {
            @Override
            protected void populateItem(final Item<ProjectProgressDto> item) {
                ProjectProgressDto projectProgressDto = item.getModelObject();
                RepeatingView repeatingView = new RepeatingView("dataRow");
                repeatingView.add(new Label(repeatingView.newChildId(), projectProgressDto.getProjectName()));
                repeatingView.add(new Label(repeatingView.newChildId(), projectProgressDto.getBuildingName()));
                repeatingView.add(new Label(repeatingView.newChildId(), projectProgressDto.getPersonName()));
                repeatingView.add(new Label(repeatingView.newChildId(), projectProgressDto.isStatusDone() == true ? "DONE" : "NOT DONE"));

                item.add(repeatingView);
                item.add(AttributeModifier.replace("class", new AbstractReadOnlyModel<String>() {
                    private static final long serialVersionUID = 1L;

                    @Override
                    public String getObject() {
                        return (item.getIndex() % 2 == 1) ? "even" : "odd";
                    }
                }));
            }
        };
        return dataView;
    }

    /**
     * method to populate building dropdown
     */
    public static DropDownChoice<BuildingDto> populateBuildingDropDown() {
        ProjectProgressService service = new ProjectProgressServiceImpl();
        List<BuildingDto> allProjects = service.findAllBuildings();
        Model<BuildingDto> listModel = new Model<BuildingDto>();
        ChoiceRenderer<BuildingDto> projectRender = new ChoiceRenderer<BuildingDto>("name", "id");
        DropDownChoice<BuildingDto> buildingLookupChoice = new DropDownChoice<BuildingDto>("buildings", listModel, allProjects, projectRender) {
            @Override
            protected boolean wantOnSelectionChangedNotifications() {
                return true;
            }
        };
        buildingLookupChoice.setNullValid(true);
        return buildingLookupChoice;
    }


    /**
     * method to populate project dropdown
     */
    public static DropDownChoice<Lookup> populateProjectDropDown() {
        DropDownChoice<Lookup> projectsLookupChoice = null;
        ProjectProgressService service = new ProjectProgressServiceImpl();
        List<Lookup> allProjects = service.findAllProjects();
        Model<Lookup> listModel = new Model<Lookup>();
        ChoiceRenderer<Lookup> projectRender = new ChoiceRenderer<Lookup>("name", "id");
        projectsLookupChoice = new DropDownChoice<Lookup>("projects", listModel, allProjects, projectRender) {
            @Override
            protected boolean wantOnSelectionChangedNotifications() {
                return true;
            }
        };
        projectsLookupChoice.setNullValid(true);
        return projectsLookupChoice;
    }

    /**
     * method to populate person drop down
     */
    public static DropDownChoice<PersonDto> populatePersonDropDown() {
        DropDownChoice<PersonDto> personLookupChoice = null;
        try {
            ProjectProgressService service = new ProjectProgressServiceImpl();
            List<PersonDto> allPersons = service.findAllPersons();
            Model<PersonDto> listModel = new Model<PersonDto>();
            ChoiceRenderer<PersonDto> projectRender = new ChoiceRenderer<PersonDto>("firstName", "id");
            personLookupChoice = new DropDownChoice<PersonDto>("persons", listModel, allPersons, projectRender) {
                @Override
                protected boolean wantOnSelectionChangedNotifications() {
                    return true;
                }
            };
            personLookupChoice.setNullValid(true);
        } catch (Exception ex) {
            logger.error("exception " + ex);
        }
        return personLookupChoice;
    }
}
