package com.gre.todo.web.pages.common;

import com.gre.todo.web.pages.building.BuildingPage;
import com.gre.todo.web.pages.person.PersonPage;
import com.gre.todo.web.pages.project.TodoListPage;
import com.gre.todo.web.pages.home.HomePage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;

/**
 * Navigation bar having all links like Home, About, Contact
 * Created by Jan_R on 13/05/2017.
 */
public class NavigationPanel extends Panel {
    public NavigationPanel(String id) {
        super(id);
        add(new BookmarkablePageLink<>("homeLink", HomePage.class));
        add(new BookmarkablePageLink<>("todoLink", TodoListPage.class));
        add(new BookmarkablePageLink<>("personLink", PersonPage.class));
        add(new BookmarkablePageLink<>("buildingLink", BuildingPage.class));
    }

}
