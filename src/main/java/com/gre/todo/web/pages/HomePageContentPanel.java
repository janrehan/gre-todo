package com.gre.todo.web.pages;

import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;

/**
 * Created by Jan_R on 13/05/2017.
 */
public class HomePageContentPanel extends Panel {
    public HomePageContentPanel(String id) {
        super(id);
        add(new BookmarkablePageLink<>("todoListLink", TodoListPage.class));
    }

}
