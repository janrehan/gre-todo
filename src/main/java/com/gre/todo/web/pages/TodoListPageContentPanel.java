package com.gre.todo.web.pages;

import com.gre.todo.dto.Lookup;
import com.gre.todo.dto.ProjectProgressDto;
import com.gre.todo.services.ProjectProgressService;
import com.gre.todo.services.ProjectProgressServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;

import java.util.List;

/**
 * this class takes user input params and filter project to do list based on those params
 * initially all todos are shown on page load
 * Created by Jan_R on 07/05/2017.
 */
public class TodoListPageContentPanel extends Panel {
    private static final Logger logger = LogManager.getLogger(TodoListPageContentPanel.class);

    public TodoListPageContentPanel(String id) {
        super(id);
        add(new TodoListForm("todoListForm"));
    }

    /**
     *
     */
    class TodoListForm extends Form {
        private DropDownChoice<Lookup> projectsLookupChoice;
        private DropDownChoice<Lookup> buildingLookupChoice;
        private DropDownChoice<Lookup> personLookupChoice;

        /**
         * load drop down values
         *
         * @param id
         */
        public TodoListForm(String id) {
            super(id);
            setDefaultModel(new CompoundPropertyModel(this));
            logger.info("populating dropdowns");
            populateProjectDropDown();
            populateBuildingDropDown();
            populatePersonDropDown();
            logger.info("loading all projects");
            fetchTodosList(null, null, null);
        }


        /**
         *
         */
        public final void onSubmit() {
            logger.info("filtering projects on form submit");
            processTodoListFilterRequest();
        }

        /**
         * this method takes user input and filter project
         * todos based on that input params
         */
        private void processTodoListFilterRequest() {
            remove("rows");
            Long projectId = null;
            Long buildingId = null;
            Long personId = null;
            if (projectsLookupChoice.getModel() != null && projectsLookupChoice.getModel().getObject() != null)
                projectId = projectsLookupChoice.getModel().getObject().getId();

            if (buildingLookupChoice.getModel() != null && buildingLookupChoice.getModel().getObject() != null)
                buildingId = buildingLookupChoice.getModel().getObject().getId();

            if (personLookupChoice.getModel() != null && personLookupChoice.getModel().getObject() != null)
                personId = personLookupChoice.getModel().getObject().getId();

            //call service method to filter projects
            fetchTodosList(projectId, buildingId, personId);

        }

        /**
         * this method call service methods to get project progress or project's todos
         *
         * @param projectId
         * @param buildingId
         * @param personId
         */
        private void fetchTodosList(Long projectId, Long buildingId, Long personId) {

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
            add(dataView);
        }


        /**
         * method to populate building dropdown
         */
        private void populateBuildingDropDown() {
            ProjectProgressService service = new ProjectProgressServiceImpl();
            List<Lookup> allProjects = service.findAllBuildings();
            Model<Lookup> listModel = new Model<Lookup>();
            ChoiceRenderer<Lookup> projectRender = new ChoiceRenderer<Lookup>("name", "id");
            buildingLookupChoice = new DropDownChoice<Lookup>("buildings", listModel, allProjects, projectRender) {
                @Override
                protected boolean wantOnSelectionChangedNotifications() {
                    return true;
                }
            };
            buildingLookupChoice.setNullValid(true);
            add(buildingLookupChoice);
        }


        /**
         * method to populate project dropdown
         */
        private void populateProjectDropDown() {
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

            add(projectsLookupChoice);
        }

        /**
         * method to populate person drop down
         */
        private void populatePersonDropDown() {
            ProjectProgressService service = new ProjectProgressServiceImpl();
            List<Lookup> allProjects = service.findAllPersons();
            Model<Lookup> listModel = new Model<Lookup>();
            ChoiceRenderer<Lookup> projectRender = new ChoiceRenderer<Lookup>("name", "id");
            personLookupChoice = new DropDownChoice<Lookup>("persons", listModel, allProjects, projectRender) {
                @Override
                protected boolean wantOnSelectionChangedNotifications() {
                    return true;
                }
            };
            personLookupChoice.setNullValid(true);
            add(personLookupChoice);
        }

    }

}
