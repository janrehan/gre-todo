package com.gre.todo.web.pages.base;

import com.gre.todo.web.pages.common.FooterPanel;
import com.gre.todo.web.pages.common.NavigationPanel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

/**
 * this class would be used as a base template throughout
 * this web application for all pages
 * Created by Jan_R on 13/05/2017.
 */
public class BaseWebTemplate extends WebPage {
    private static final Logger logger = LogManager.getLogger(BaseWebTemplate.class);

    public static final String CONTENT_ID = "contentComponent";
    Component navigationPanel;
    Component footerPanel;

    public BaseWebTemplate() {
        add(navigationPanel = new NavigationPanel("navigationPanel"));
        add(footerPanel = new FooterPanel("footerPanel"));
        //each page will replace specified content on div or panel
        add(new Label(CONTENT_ID, "Put your content here"));
    }
}
