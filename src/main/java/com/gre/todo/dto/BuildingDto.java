package com.gre.todo.dto;

import java.io.Serializable;

/**
 * Created by Jan_R on 14/05/2017.
 */
public class BuildingDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String location;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BuildingDto that = (BuildingDto) o;

        if (!getId().equals(that.getId())) return false;
        if (!getName().equals(that.getName())) return false;
        return getLocation().equals(that.getLocation());

    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getLocation().hashCode();
        return result;
    }
}
