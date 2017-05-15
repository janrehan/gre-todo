package com.gre.todo.web.pages.person.delete;

import com.gre.todo.dto.PersonDto;
import com.gre.todo.services.ProjectProgressService;
import com.gre.todo.services.ProjectProgressServiceImpl;
import com.gre.todo.web.pages.person.PersonPage;
import com.gre.todo.web.util.HelperUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import java.util.List;

/**
 * Created by Jan_R on 15/05/2017.
 */
public class PersonPageDeleteContentPanel extends Panel {
    private static final Logger logger = LogManager.getLogger(PersonPageDeleteContentPanel.class);

    public PersonPageDeleteContentPanel(String id) {
        super(id);
        PersonDto personDto = new PersonDto();
        add(new PersonForm("personForm", new Model<PersonDto>(personDto)));
    }

    class PersonForm extends Form<PersonDto> {
        public PersonForm(String id, IModel<PersonDto> model) {
            super(id, new CompoundPropertyModel<PersonDto>(model));
            //email
            TextField<String> emailField = new TextField<String>("email");
            emailField.setRequired(true);
            add(emailField);
            add(new FeedbackPanel("feedback"));
            add(new BookmarkablePageLink<>("addLink", PersonPage.class));
            add(HelperUtil.getAllPersonsDataView());
        }

        /**
         *
         */
        protected void onSubmit() {
            ProjectProgressService service = new ProjectProgressServiceImpl();
            if (!service.isPersonAlreadyExist(getModel().getObject().getEmail())) {
                getSession().success("Person with this email address does not exist");
                return;
            }

            if (!service.removePersonByEmail(getModel().getObject().getEmail())) {
                getSession().success("Failed to delete person as it could be associated with other projects");
                return;
            }

            getSession().success("Person deleted successfully");
            remove("rows");
            //reload all persons to show in the grid
            add(HelperUtil.getAllPersonsDataView());

        }

    }


}
