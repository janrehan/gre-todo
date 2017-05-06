package com.gre.todo.services;

import com.gre.todo.dto.ProjectProgressDto;

import java.util.List;

/**
 * Created by Jan_R on 06/05/2017.
 */
public interface ProjectProgressService
{

	/**
	 *  find project's associated buildings, person and status info
	 * @param projectId
	 * @return
	 */
	List<ProjectProgressDto> findProjectProgressByProjectId(Long projectId);

}
