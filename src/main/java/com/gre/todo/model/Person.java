package com.gre.todo.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Jan_R on 06/05/2017.
 */
@Entity
@Table(name = "person")
public class Person
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "building", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<ProjectProgress> projectProgress;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Set<ProjectProgress> getProjectProgress()
	{
		return projectProgress;
	}

	public void setProjectProgress(Set<ProjectProgress> projectProgress)
	{
		this.projectProgress = projectProgress;
	}
}
