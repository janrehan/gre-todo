package com.gre.todo.web.pages;

import com.gre.todo.util.GreStreamLocator;
import com.gre.todo.web.pages.home.HomePage;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;

/**
 * Application object for your web application.
 * If you want to run this application without deploying, run the Start class.
 *
 * @see com.gre.todo.Start#main(String[])
 */
public class GreApplication extends WebApplication {
    /**
     * @see org.apache.wicket.Application#getHomePage()
     */
    @Override
    public Class<? extends WebPage> getHomePage() {
        return HomePage.class;
    }

    /**
     * @see org.apache.wicket.Application#init()
     */
    @Override
    public void init() {
        super.init();
        //not using stream location anymore as changed project hierarchy
        //getResourceSettings().setResourceStreamLocator(new GreStreamLocator());

    }
}
