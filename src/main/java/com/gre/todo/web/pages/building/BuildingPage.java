package com.gre.todo.web.pages.building;

import com.gre.todo.web.pages.base.BaseWebTemplate;
import com.gre.todo.web.pages.person.PersonPageContentPanel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * Created by Jan_R on 15/05/2017.
 */
public class BuildingPage extends BaseWebTemplate {

    private static final Logger logger = LogManager.getLogger(BuildingPage.class);

    public BuildingPage(final PageParameters parameters) {
        super();
        replace(new BuildingPageContentPanel(CONTENT_ID));
    }

}
