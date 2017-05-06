package com.gre.todo.services;

import com.gre.todo.dto.ProjectProgressDto;
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
	 * find project's associated buildings, person and status info
	 * @param projectId
	 * @return
	 */
	@Override
	public List<ProjectProgressDto> findProjectProgressByProjectId(Long projectId)
	{
		ProjectProgressRepo projectProgressRepo = new ProjectProgressRepoImpl();
		List<ProjectProgress> projectProgressResultList = projectProgressRepo.findProjectProgressByProjectId(projectId);
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
