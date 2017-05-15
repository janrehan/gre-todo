package com.gre.todo.web.pages.home;

import com.gre.todo.web.pages.building.BuildingPage;
import com.gre.todo.web.pages.person.PersonPage;
import com.gre.todo.web.pages.person.delete.PersonDeletePage;
import com.gre.todo.web.pages.project.TodoListPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;

/**
 * Created by Jan_R on 13/05/2017.
 */
public class HomePageContentPanel extends Panel {
    public HomePageContentPanel(String id) {
        super(id);
        add(new BookmarkablePageLink<>("todoListLink", TodoListPage.class));
        add(new BookmarkablePageLink<>("manageProjectsLink", TodoListPage.class));
        add(new BookmarkablePageLink<>("manageBuildingLink", BuildingPage.class));
        add(new BookmarkablePageLink<>("managePersonAddLink", PersonPage.class));
        add(new BookmarkablePageLink<>("managePersonDeleteLink", PersonDeletePage.class));
    }

}
