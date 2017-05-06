package com.gre.todo;

import com.gre.todo.dto.ProjectProgressDto;
import com.gre.todo.services.ProjectProgressService;
import com.gre.todo.services.ProjectProgressServiceImpl;
import junit.framework.TestCase;

import java.util.List;

/**
 * Created by Jan_R on 5/5/2017.
 */
public class TestProjectProgressService extends TestCase
{
	public void testAppService()
	{
		ProjectProgressService projectProgressService =  new ProjectProgressServiceImpl();
		List<ProjectProgressDto> projectProgressDtoList = projectProgressService.findProjectProgressByProjectId(1L);
		System.out.println("done");
	}
}