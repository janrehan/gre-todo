package com.gre.todo.web.pages.person.delete;

import com.gre.todo.web.pages.base.BaseWebTemplate;
import com.gre.todo.web.pages.person.PersonPageContentPanel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * Created by Jan_R on 15/05/2017.
 */
public class PersonDeletePage extends BaseWebTemplate {

    private static final Logger logger = LogManager.getLogger(PersonDeletePage.class);

    public PersonDeletePage(final PageParameters parameters) {
        super();
        replace(new PersonPageDeleteContentPanel(CONTENT_ID));
    }

}
