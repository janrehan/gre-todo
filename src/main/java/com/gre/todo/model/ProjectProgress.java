package com.gre.todo.model;

import javax.persistence.*;

/**
 * Created by Jan_R on 06/05/2017.
 */
@Entity
@Table(name = "project_progress")
public class ProjectProgress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Project project;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Building building;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Person person;

    @Column(name = "is_status_done")
    private Boolean statusDone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Boolean getStatusDone() {
        return statusDone;
    }

    public void setStatusDone(Boolean statusDone) {
        this.statusDone = statusDone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProjectProgress that = (ProjectProgress) o;

        if (!getId().equals(that.getId())) return false;
        return getStatusDone().equals(that.getStatusDone());

    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getStatusDone().hashCode();
        return result;
    }
}
