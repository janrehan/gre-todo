package com.gre.todo.web.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * to do list main page which extends base template having
 * navigation, content and footer panels
 * Created by Jan_R on 07/05/2017.
 */
public class TodoListPage extends BaseWebTemplate
{

	private static final Logger logger =  LogManager.getLogger(TodoListPage.class);
	public TodoListPage(final PageParameters parameters)
	{
		super();
		replace(new TodoListPageContentPanel(CONTENT_ID));
	}
}
