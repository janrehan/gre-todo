package com.gre.todo.repository;

import com.gre.todo.model.Building;
import com.gre.todo.model.Person;
import com.gre.todo.model.Project;
import com.gre.todo.model.ProjectProgress;

import java.util.List;

/**
 * Created by Jan_R on 06/05/2017.
 */
public interface ProjectProgressRepo {

    /**
     * get all registered projects
     *
     * @return
     */
    public List<Project> findAllProjects();

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
