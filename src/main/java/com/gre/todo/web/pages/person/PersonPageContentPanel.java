package com.gre.todo.web.pages.person;

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
public class PersonPageContentPanel extends Panel {
    private static final Logger logger = LogManager.getLogger(PersonPageContentPanel.class);

    public PersonPageContentPanel(String id) {
        super(id);
        PersonDto personDto = new PersonDto();
        add(new PersonForm("personForm", new Model<PersonDto>(personDto)));
    }

    class PersonForm extends Form<PersonDto> {
        public PersonForm(String id, IModel<PersonDto> model) {
            super(id, new CompoundPropertyModel<PersonDto>(model));
            //first name
            TextField<String> firstName = new TextField<String>("firstName");
            firstName.setRequired(true);
            add(firstName);
            //last name
            TextField<String> lastName = new TextField<String>("lastName");
            lastName.setRequired(true);
            add(lastName);
            //email
            TextField<String> emailField = new TextField<String>("email");
            emailField.setRequired(true);
            add(emailField);
            add(new FeedbackPanel("feedback"));
            getAllPersons();
        }

        /**
         *
         */
        public final void onSubmit() {
            ProjectProgressService service = new ProjectProgressServiceImpl();
            service.savePerson(getModel().getObject());
            getSession().success("Person added successfully");
            remove("rows");
            getAllPersons();
        }

        /**
         *
         */
        private void getAllPersons() {
            try {
                ProjectProgressService service = new ProjectProgressServiceImpl();
                logger.info("calling service method to get all persons");
                List<PersonDto> personDtoList = service.findAllPersons();
                ListDataProvider<PersonDto> listDataProvider = new ListDataProvider<PersonDto>(personDtoList);
                DataView<PersonDto> dataView = new DataView<PersonDto>("rows", listDataProvider) {
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
                add(dataView);
            } catch (Exception ex) {
                logger.error("exception while getting person data");
            }
        }
    }
}
