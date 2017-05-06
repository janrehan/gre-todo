package com.gre.todo.repository;

import com.gre.todo.model.ProjectProgress;

import java.util.List;

/**
 * Created by Jan_R on 06/05/2017.
 */
public interface ProjectProgressRepo
{

	/**
	 * find project's associated buildings, person and status info
	 * @param projectId
	 * @return
	 */
	public List<ProjectProgress> findProjectProgressByProjectId(Long projectId);

}
