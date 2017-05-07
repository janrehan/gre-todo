package com.gre.todo.repository;

import com.gre.todo.model.Building;
import com.gre.todo.model.Person;
import com.gre.todo.model.Project;
import com.gre.todo.model.ProjectProgress;

import java.util.List;

/**
 * Created by Jan_R on 06/05/2017.
 */
public interface ProjectProgressRepo
{

	/**
	 * get all registered projects
	 *
	 * @return
	 */
	public List<Project> findAllProjects();

	/**
	 * get all registered buildings
	 *
	 * @return
	 */
	public List<Building> findAllBuildings();

	/**
	 * get all persons
	 *
	 * @return
	 */
	public List<Person> findAllPersons();

	/**
	 * find project's associated buildings, person and status info
	 * by projectId
	 *
	 * @param projectId
	 * @return
	 */
	public List<ProjectProgress> findProjectProgressBy(Long projectId);

	/**
	 * find project's associated buildings, person and status info
	 * by projectId and buildingId
	 *
	 * @param projectId
	 * @param buildingId
	 * @return
	 */
	public List<ProjectProgress> findProjectProgressBy(Long projectId, Long buildingId);

	/**
	 * find project's associated buildings, person and status info
	 * by projectId, buildingId and personId
	 *
	 * @param projectId
	 * @param buildingId
	 * @param personId
	 * @return
	 */
	public List<ProjectProgress> findProjectProgressBy(Long projectId, Long buildingId, Long personId);

}
