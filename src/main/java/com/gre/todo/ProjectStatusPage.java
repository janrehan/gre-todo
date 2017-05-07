package com.gre.todo;

import com.gre.todo.dto.Lookup;
import com.gre.todo.dto.ProjectProgressDto;
import com.gre.todo.model.Project;
import com.gre.todo.services.ProjectProgressService;
import com.gre.todo.services.ProjectProgressServiceImpl;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.form.*;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.CompoundPropertyModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jan_R on 07/05/2017.
 */
public class ProjectStatusPage extends WebPage
{
	public ProjectStatusPage(final PageParameters parameters)
	{
		super(parameters);
		add(new ProjectStatusForm("projectStatusForm"));
	}

	class ProjectStatusForm extends Form
	{
		private DropDownChoice<Lookup> projectsLookupChoice;
		private DropDownChoice<Lookup> buildingLookupChoice;
		private DropDownChoice<Lookup> personLookupChoice;

		public ProjectStatusForm(String id)
		{
			super(id);
			setDefaultModel(new CompoundPropertyModel(this));

			populateProjectDropDown();
			populateBuildingDropDown();
			populatePersonDropDown();
			findProjectProgress(1L);
		}

		public final void onSubmit()
		{
			remove("rows");
			findProjectProgress(projectsLookupChoice.getModel().getObject().getId().longValue());
			System.out.println("selected id " + projectsLookupChoice.getModel().getObject().getId());
		}

		private void populateBuildingDropDown()
		{
			ProjectProgressService service = new ProjectProgressServiceImpl();
			List<Lookup> allProjects = service.findAllBuildings();
			Model<Lookup> listModel = new Model<Lookup>();
			ChoiceRenderer<Lookup> projectRender = new ChoiceRenderer<Lookup>("name", "id");
			buildingLookupChoice = new DropDownChoice<Lookup>("buildings", listModel, allProjects, projectRender)
			{
				@Override
				protected boolean wantOnSelectionChangedNotifications()
				{
					return true;
				}
			};
			add(buildingLookupChoice);
		}


		private void populateProjectDropDown()
		{
			ProjectProgressService service = new ProjectProgressServiceImpl();
			List<Lookup> allProjects = service.findAllProjects();
			Model<Lookup> listModel = new Model<Lookup>();
			ChoiceRenderer<Lookup> projectRender = new ChoiceRenderer<Lookup>("name", "id");
			projectsLookupChoice = new DropDownChoice<Lookup>("projects", listModel, allProjects, projectRender)
			{
				@Override
				protected boolean wantOnSelectionChangedNotifications()
				{
					return true;
				}
			};
			add(projectsLookupChoice);
		}

		private void populatePersonDropDown()
		{
			ProjectProgressService service = new ProjectProgressServiceImpl();
			List<Lookup> allProjects = service.findAllBuildings();
			Model<Lookup> listModel = new Model<Lookup>();
			ChoiceRenderer<Lookup> projectRender = new ChoiceRenderer<Lookup>("name", "id");
			personLookupChoice = new DropDownChoice<Lookup>("persons", listModel, allProjects, projectRender)
			{
				@Override
				protected boolean wantOnSelectionChangedNotifications()
				{
					return true;
				}
			};
			add(personLookupChoice);
		}

		private void findProjectProgress(Long projectId)
		{

			ProjectProgressService service = new ProjectProgressServiceImpl();
			List<ProjectProgressDto> ProjectProgressDtoResultList = service.findProjectProgressBy(projectId);
			ListDataProvider<ProjectProgressDto> listDataProvider = new ListDataProvider<ProjectProgressDto>(ProjectProgressDtoResultList);
			DataView<ProjectProgressDto> dataView = new DataView<ProjectProgressDto>("rows", listDataProvider)
			{
				@Override
				protected void populateItem(final Item<ProjectProgressDto> item)
				{
					ProjectProgressDto projectProgressDto = item.getModelObject();
					RepeatingView repeatingView = new RepeatingView("dataRow");
					repeatingView.add(new Label(repeatingView.newChildId(), projectProgressDto.getProjectName()));
					repeatingView.add(new Label(repeatingView.newChildId(), projectProgressDto.getBuildingName()));
					repeatingView.add(new Label(repeatingView.newChildId(), projectProgressDto.getPersonName()));
					repeatingView.add(new Label(repeatingView.newChildId(), projectProgressDto.isStatusDone()));
					item.add(repeatingView);
					item.add(AttributeModifier.replace("class", new AbstractReadOnlyModel<String>()
					{
						private static final long serialVersionUID = 1L;
						@Override
						public String getObject()
						{
							return (item.getIndex() % 2 == 1) ? "even" : "odd";
						}
					}));
				}
			};
			add(dataView);
		}
	}

}
