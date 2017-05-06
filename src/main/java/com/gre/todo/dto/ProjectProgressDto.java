package com.gre.todo.dto;

/**
 * this dto can be used on presentation layer to show project progress
 * Created by Jan_R on 06/05/2017.
 */
public class ProjectProgressDto
{
	private Long projectProgressId;
	private Long projectId;
	private String projectName;
	private Long buildingId;
	private String buildingName;
	private Long personId;
	private String personName;
	boolean isStatusDone;

	public Long getProjectId()
	{
		return projectId;
	}

	public void setProjectId(Long projectId)
	{
		this.projectId = projectId;
	}

	public String getProjectName()
	{
		return projectName;
	}

	public void setProjectName(String projectName)
	{
		this.projectName = projectName;
	}

	public Long getBuildingId()
	{
		return buildingId;
	}

	public void setBuildingId(Long buildingId)
	{
		this.buildingId = buildingId;
	}

	public String getBuildingName()
	{
		return buildingName;
	}

	public void setBuildingName(String buildingName)
	{
		this.buildingName = buildingName;
	}

	public Long getPersonId()
	{
		return personId;
	}

	public void setPersonId(Long personId)
	{
		this.personId = personId;
	}

	public String getPersonName()
	{
		return personName;
	}

	public void setPersonName(String personName)
	{
		this.personName = personName;
	}

	public boolean isStatusDone()
	{
		return isStatusDone;
	}

	public void setStatusDone(boolean statusDone)
	{
		isStatusDone = statusDone;
	}

	public Long getProjectProgressId()
	{
		return projectProgressId;
	}

	public void setProjectProgressId(Long projectProgressId)
	{
		this.projectProgressId = projectProgressId;
	}
}
