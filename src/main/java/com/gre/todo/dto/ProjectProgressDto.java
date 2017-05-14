package com.gre.todo.dto;

import org.apache.wicket.util.io.IClusterable;

import java.io.Serializable;

/**
 * this dto can be used on presentation layer to show project progress
 * Created by Jan_R on 06/05/2017.
 */
public class ProjectProgressDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long projectProgressId;
    private Long projectId;
    private String projectName;
    private Long buildingId;
    private String buildingName;
    private Long personId;
    private String personName;
    boolean isStatusDone;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public boolean isStatusDone() {
        return isStatusDone;
    }

    public void setStatusDone(boolean statusDone) {
        isStatusDone = statusDone;
    }

    public Long getProjectProgressId() {
        return projectProgressId;
    }

    public void setProjectProgressId(Long projectProgressId) {
        this.projectProgressId = projectProgressId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProjectProgressDto that = (ProjectProgressDto) o;

        if (isStatusDone() != that.isStatusDone()) return false;
        if (!getProjectProgressId().equals(that.getProjectProgressId())) return false;
        if (!getProjectId().equals(that.getProjectId())) return false;
        if (!getProjectName().equals(that.getProjectName())) return false;
        if (!getBuildingId().equals(that.getBuildingId())) return false;
        if (!getBuildingName().equals(that.getBuildingName())) return false;
        if (!getPersonId().equals(that.getPersonId())) return false;
        return getPersonName().equals(that.getPersonName());

    }

    @Override
    public int hashCode() {
        int result = getProjectProgressId().hashCode();
        result = 31 * result + getProjectId().hashCode();
        result = 31 * result + getProjectName().hashCode();
        result = 31 * result + getBuildingId().hashCode();
        result = 31 * result + getBuildingName().hashCode();
        result = 31 * result + getPersonId().hashCode();
        result = 31 * result + getPersonName().hashCode();
        result = 31 * result + (isStatusDone() ? 1 : 0);
        return result;
    }
}
