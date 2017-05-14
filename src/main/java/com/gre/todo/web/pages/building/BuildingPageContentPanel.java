package com.gre.todo.web.pages.building;

import com.gre.todo.dto.BuildingDto;
import com.gre.todo.dto.PersonDto;
import com.gre.todo.services.ProjectProgressService;
import com.gre.todo.services.ProjectProgressServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import java.util.List;

/**
 * Created by Jan_R on 15/05/2017.
 */
public class BuildingPageContentPanel extends Panel {
    private static final Logger logger = LogManager.getLogger(BuildingPageContentPanel.class);

    public BuildingPageContentPanel(String id) {
        super(id);
        BuildingDto buildingDto = new BuildingDto();
        add(new BuildingForm("buildingForm", new Model<BuildingDto>(buildingDto)));
    }

    class BuildingForm extends Form<BuildingDto> {
        public BuildingForm(String id, IModel<BuildingDto> model) {
            super(id, new CompoundPropertyModel<BuildingDto>(model));
            //name
            TextField<String> name = new TextField<String>("name");
            name.setRequired(true);
            add(name);
            //last name
            TextField<String> location = new TextField<String>("location");
            location.setRequired(true);
            add(location);
            //feedback
            add(new FeedbackPanel("feedback"));
            //load all buildings to show in a grid
            getAllBuildings();
        }

        /**
         *
         */
        public final void onSubmit() {
            ProjectProgressService service = new ProjectProgressServiceImpl();
            service.saveBuilding(getModel().getObject());
            getSession().success("Building added successfully");
            remove("rows");
            //reload all persons to show in the grid
            getAllBuildings();
        }

        /**
         *
         */
        private void getAllBuildings() {
            try {
                ProjectProgressService service = new ProjectProgressServiceImpl();
                logger.info("calling service method to get all buildings");
                List<BuildingDto> buildingDtoList = service.findAllBuildings();
                ListDataProvider<BuildingDto> listDataProvider = new ListDataProvider<BuildingDto>(buildingDtoList);
                DataView<BuildingDto> dataView = new DataView<BuildingDto>("rows", listDataProvider) {
                    @Override
                    protected void populateItem(final Item<BuildingDto> item) {
                        BuildingDto buildingDto = item.getModelObject();
                        RepeatingView repeatingView = new RepeatingView("dataRow");
                        repeatingView.add(new Label(repeatingView.newChildId(), buildingDto.getName()));
                        repeatingView.add(new Label(repeatingView.newChildId(), buildingDto.getLocation()));
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
            } catch (Exception ex) {
                logger.error("exception while getting buildings data");
            }
        }
    }
}
