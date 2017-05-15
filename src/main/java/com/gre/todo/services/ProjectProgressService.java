package com.gre.todo.services;

import com.gre.todo.dto.BuildingDto;
import com.gre.todo.dto.Lookup;
import com.gre.todo.dto.PersonDto;
import com.gre.todo.dto.ProjectProgressDto;

import java.util.List;

/**
 * Created by Jan_R on 06/05/2017.
 */
public interface ProjectProgressService {

    /**
     * get all registered projects
     *
     * @return
     */
    public List<Lookup> findAllProjects();

    /**
     * get all registered buildings
     *
     * @return
     */
    public List<BuildingDto> findAllBuildings();


    /**
     * @param buildingDto
     */
    public void saveBuilding(BuildingDto buildingDto);


    /**
     * get all persons
     *
     * @return
     */
    public List<PersonDto> findAllPersons() throws Exception;

    /**
     * @param person
     */
    public void savePerson(PersonDto person);


    /**
     * @param email
     * @return
     */
    public boolean isPersonAlreadyExist(String email);


    /**
     *
     * @param email
     * @return
     */
    public boolean removePersonByEmail(String email);

    /**
     * find project's associated buildings, person and status info
     * by projectId, buildingId and personId
     *
     * @param projectId
     * @param buildingId
     * @param personId
     * @return
     */
    public List<ProjectProgressDto> findProjectProgressBy(Long projectId, Long buildingId, Long personId);

}
