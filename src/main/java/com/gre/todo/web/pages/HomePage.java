package com.gre.todo.web.pages;


import org.apache.wicket.request.mapper.parameter.PageParameters;


/**
 * home page or landing page to show application features
 */
public class HomePage extends BaseWebTemplate
{
	private static final long serialVersionUID = 1L;
	public HomePage(final PageParameters parameters)
	{
		super();
		replace(new HomePageContentPanel(CONTENT_ID));
	}
}
