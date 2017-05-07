package com.gre.todo.dto;

import java.io.Serializable;

/**
 * Created by Jan_R on 07/05/2017.
 */
public class Lookup implements Serializable
{
	private Long id;
	private String name;

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
}
