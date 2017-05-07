package com.gre.todo.services;

import com.gre.todo.dto.Lookup;
import com.gre.todo.dto.ProjectProgressDto;
import com.gre.todo.model.Building;
import com.gre.todo.model.Person;
import com.gre.todo.model.Project;
import com.gre.todo.model.ProjectProgress;
import com.gre.todo.repository.ProjectProgressRepo;
import com.gre.todo.repository.ProjectProgressRepoImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jan_R on 06/05/2017.
 */
public class ProjectProgressServiceImpl implements ProjectProgressService
{

	/**
	 * get all registered projects
	 *
	 * @return
	 */
	@Override
	public List<Lookup> findAllProjects()
	{
		ProjectProgressRepo projectProgressRepo = new ProjectProgressRepoImpl();
		List<Project> allProjects = projectProgressRepo.findAllProjects();
		List<Lookup> projectsLookup = new ArrayList<Lookup>();
		if (allProjects != null)
		{
			Lookup lookup = null;
			for (Project project : allProjects)
			{
				lookup = new Lookup();
				lookup.setId(project.getId());
				lookup.setName(project.getName());
				projectsLookup.add(lookup);
			}
		}
		return projectsLookup;
	}

	/**
	 * get all buildings info
	 *
	 * @return
	 */
	@Override
	public List<Lookup> findAllBuildings()
	{
		ProjectProgressRepo projectProgressRepo = new ProjectProgressRepoImpl();
		List<Building> allBuildings = projectProgressRepo.findAllBuildings();
		List<Lookup> buildingLookup = new ArrayList<Lookup>();
		if (allBuildings != null)
		{
			Lookup lookup = null;
			for (Building building : allBuildings)
			{
				lookup = new Lookup();
				lookup.setId(building.getId());
				lookup.setName(building.getName());
				buildingLookup.add(lookup);
			}
		}
		return buildingLookup;
	}

	/**
	 * get all persons info
	 *
	 * @return
	 */
	@Override
	public List<Lookup> findAllPersons()
	{
		ProjectProgressRepo projectProgressRepo = new ProjectProgressRepoImpl();
		List<Person> allPersons = projectProgressRepo.findAllPersons();
		List<Lookup> personLookup = new ArrayList<Lookup>();
		if (allPersons != null)
		{
			Lookup lookup = null;
			for (Person person : allPersons)
			{
				lookup = new Lookup();
				lookup.setId(person.getId());
				lookup.setName(person.getName());
				personLookup.add(lookup);
			}
		}
		return personLookup;
	}

	/**
	 * find project's associated buildings, person and status info
	 * by projectId
	 *
	 * @param projectId
	 * @return
	 */
	@Override
	public List<ProjectProgressDto> findProjectProgressBy(Long projectId)
	{
		ProjectProgressRepo projectProgressRepo = new ProjectProgressRepoImpl();
		List<ProjectProgress> projectProgressResultList = projectProgressRepo.findProjectProgressBy(projectId);
		return populateProjectProgressDto(projectProgressResultList);
	}

	/**
	 * find project's associated buildings, person and status info
	 * by projectId and buildingId
	 *
	 * @param projectId
	 * @param buildingId
	 * @return
	 */
	@Override
	public List<ProjectProgressDto> findProjectProgressBy(Long projectId, Long buildingId)
	{
		ProjectProgressRepo projectProgressRepo = new ProjectProgressRepoImpl();
		List<ProjectProgress> projectProgressResultList = projectProgressRepo.findProjectProgressBy(projectId, buildingId);
		return populateProjectProgressDto(projectProgressResultList);
	}

	/**
	 * find project's associated buildings, person and status info
	 * by projectId, buildingId and personId
	 *
	 * @param projectId
	 * @param buildingId
	 * @param personId
	 * @return
	 */
	@Override
	public List<ProjectProgressDto> findProjectProgressBy(Long projectId, Long buildingId, Long personId)
	{
		ProjectProgressRepo projectProgressRepo = new ProjectProgressRepoImpl();
		List<ProjectProgress> projectProgressResultList = projectProgressRepo.findProjectProgressBy(projectId, buildingId, personId);
		return populateProjectProgressDto(projectProgressResultList);
	}


	/**
	 * iterate result set and populate dto
	 *
	 * @param projectProgressResultList
	 * @return
	 */
	private List<ProjectProgressDto> populateProjectProgressDto(List<ProjectProgress> projectProgressResultList)
	{

		List<ProjectProgressDto> projectProgressDtoList = new ArrayList<ProjectProgressDto>();
		if (projectProgressResultList != null && !projectProgressResultList.isEmpty())
		{
			ProjectProgressDto projectProgressDto = null;
			for (ProjectProgress projectProgress : projectProgressResultList)
			{
				projectProgressDto = new ProjectProgressDto();
				projectProgressDto.setProjectProgressId(projectProgress.getId());
				projectProgressDto.setProjectId(projectProgress.getProject().getId());
				projectProgressDto.setProjectName(projectProgress.getProject().getName());
				projectProgressDto.setBuildingId(projectProgress.getBuilding().getId());
				projectProgressDto.setBuildingName(projectProgress.getBuilding().getName());
				projectProgressDto.setPersonId(projectProgress.getPerson().getId());
				projectProgressDto.setPersonName(projectProgress.getPerson().getName());
				projectProgressDto.setStatusDone(projectProgress.getStatusDone());
				projectProgressDtoList.add(projectProgressDto);
			}
		}
		return projectProgressDtoList;
	}

}
