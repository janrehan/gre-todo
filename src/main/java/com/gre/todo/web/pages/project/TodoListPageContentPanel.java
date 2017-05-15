package com.gre.todo.web.pages.project;

import com.gre.todo.dto.BuildingDto;
import com.gre.todo.dto.Lookup;
import com.gre.todo.dto.PersonDto;
import com.gre.todo.dto.ProjectProgressDto;
import com.gre.todo.services.ProjectProgressService;
import com.gre.todo.services.ProjectProgressServiceImpl;
import com.gre.todo.web.util.HelperUtil;
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

    class TodoListForm extends Form {
        private DropDownChoice<Lookup> projectsLookupChoice;
        private DropDownChoice<BuildingDto> buildingLookupChoice;
        private DropDownChoice<PersonDto> personLookupChoice;

        /**
         * load drop down values
         *
         * @param id
         */
        public TodoListForm(String id) {
            super(id);
            setDefaultModel(new CompoundPropertyModel(this));
            logger.info("populating dropdowns");
            projectsLookupChoice = HelperUtil.populateProjectDropDown();
            add(projectsLookupChoice);
            buildingLookupChoice = HelperUtil.populateBuildingDropDown();
            add(buildingLookupChoice);
            personLookupChoice = HelperUtil.populatePersonDropDown();
            add(personLookupChoice);
            logger.info("loading all projects");
            //call service method to get all projects
            DataView<ProjectProgressDto> dataView = HelperUtil.getAllProjects(null, null, null);
            add(dataView);
        }

        /**
         *
         */
        public final void onSubmit() {
            logger.info("filtering projects on form submit");
            processApplyFilterRequest();
        }

        /**
         * this method takes user input and filter project
         * todos based on those input params
         */
        private void processApplyFilterRequest() {
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
            DataView<ProjectProgressDto> dataView = HelperUtil.getAllProjects(projectId, buildingId, personId);
            add(dataView);
        }
    }
}
