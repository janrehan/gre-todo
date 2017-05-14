package com.gre.todo.services;

import com.gre.todo.dto.BuildingDto;
import com.gre.todo.dto.Lookup;
import com.gre.todo.dto.PersonDto;
import com.gre.todo.dto.ProjectProgressDto;
import com.gre.todo.model.Building;
import com.gre.todo.model.Person;
import com.gre.todo.model.Project;
import com.gre.todo.model.ProjectProgress;
import com.gre.todo.repository.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jan_R on 06/05/2017.
 */
public class ProjectProgressServiceImpl implements ProjectProgressService {
    private static final Logger logger = LogManager.getLogger(ProjectProgressServiceImpl.class);

    /**
     * get all registered projects
     *
     * @return
     */
    @Override
    public List<Lookup> findAllProjects() {
        ProjectProgressRepo projectProgressRepo = new ProjectProgressRepoImpl();
        logger.info("calling dao to load all projects");
        List<Project> allProjects = projectProgressRepo.findAllProjects();
        List<Lookup> projectsLookup = new ArrayList<Lookup>();
        if (allProjects != null) {
            Lookup lookup = null;
            for (Project project : allProjects) {
                lookup = new Lookup();
                lookup.setId(project.getId());
                lookup.setName(project.getName());
                projectsLookup.add(lookup);
            }
        }
        return projectsLookup;
    }

    /**
     * get all buildings info
     *
     * @return
     */
    @Override
    public List<BuildingDto> findAllBuildings() {

        BuildingRepo buildingRepo = new BuildingRepoImpl();
        logger.info("calling dao to load all buildings");
        List<Building> allBuildings = buildingRepo.getAllBuildings();
        List<BuildingDto> buildingDtoList = new ArrayList<BuildingDto>();
        if (allBuildings != null) {
            BuildingDto buildingDto = null;
            for (Building building : allBuildings) {
                buildingDto = new BuildingDto();
                BeanUtils.copyProperties(building, buildingDto);
                buildingDtoList.add(buildingDto);
            }
        }
        return buildingDtoList;
    }

    @Override
    public void saveBuilding(BuildingDto buildingDto) {
        BuildingRepo buildingRepo = new BuildingRepoImpl();
        Building building = new Building();
        BeanUtils.copyProperties(buildingDto, building);
        buildingRepo.saveBuilding(building);
    }


    /**
     * get all persons info
     *
     * @return
     */
    @Override
    public List<PersonDto> findAllPersons() throws Exception {
        PersonRepo personRepo = new PersonRepoImpl();
        logger.info("calling dao to load persons");
        List<Person> allPersons = personRepo.getAllPersons();
        List<PersonDto> personDtoList = new ArrayList<PersonDto>();
        if (allPersons != null) {
            PersonDto personDto = null;
            for (Person person : allPersons) {
                personDto = new PersonDto();
                BeanUtils.copyProperties(person, personDto);
                personDtoList.add(personDto);
            }
        }
        return personDtoList;
    }

    @Override
    public void savePerson(PersonDto personDto) {
        PersonRepo personRepo = new PersonRepoImpl();
        Person person = new Person();
        BeanUtils.copyProperties(personDto, person);
        personRepo.savePerson(person);
    }

    /**
     * find project's associated buildings, person and status info
     * by projectId, buildingId and personId
     *
     * @param projectId
     * @param buildingId
     * @param personId
     * @return
     */
    @Override
    public List<ProjectProgressDto> findProjectProgressBy(Long projectId, Long buildingId, Long personId) {
        ProjectProgressRepo projectProgressRepo = new ProjectProgressRepoImpl();
        logger.info("calling dao to get project todos");
        List<ProjectProgress> projectProgressResultList = projectProgressRepo.findProjectProgressBy(projectId, buildingId, personId);
        return populateProjectProgressDto(projectProgressResultList);
    }


    /**
     * iterate result set and populate dto
     *
     * @param projectProgressResultList
     * @return
     */
    private List<ProjectProgressDto> populateProjectProgressDto(List<ProjectProgress> projectProgressResultList) {

        List<ProjectProgressDto> projectProgressDtoList = new ArrayList<ProjectProgressDto>();
        if (projectProgressResultList != null && !projectProgressResultList.isEmpty()) {
            ProjectProgressDto projectProgressDto = null;
            for (ProjectProgress projectProgress : projectProgressResultList) {
                projectProgressDto = new ProjectProgressDto();
                projectProgressDto.setProjectProgressId(projectProgress.getId());
                projectProgressDto.setProjectId(projectProgress.getProject().getId());
                projectProgressDto.setProjectName(projectProgress.getProject().getName());
                projectProgressDto.setBuildingId(projectProgress.getBuilding().getId());
                projectProgressDto.setBuildingName(projectProgress.getBuilding().getName());
                projectProgressDto.setPersonId(projectProgress.getPerson().getId());
                projectProgressDto.setPersonName(projectProgress.getPerson().getFirstName());
                projectProgressDto.setStatusDone(projectProgress.getStatusDone());
                projectProgressDtoList.add(projectProgressDto);
            }
        }
        return projectProgressDtoList;
    }

}
