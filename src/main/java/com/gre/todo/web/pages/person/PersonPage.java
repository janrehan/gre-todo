package com.gre.todo.web.pages.person;

import com.gre.todo.web.pages.base.BaseWebTemplate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * Created by Jan_R on 15/05/2017.
 */
public class PersonPage extends BaseWebTemplate {

    private static final Logger logger = LogManager.getLogger(PersonPage.class);

    public PersonPage(final PageParameters parameters) {
        super();
        replace(new PersonPageContentPanel(CONTENT_ID));
    }

}
