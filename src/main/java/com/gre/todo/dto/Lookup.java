package com.gre.todo.dto;

import java.io.Serializable;

/**
 * this lookup can be used on presentation layer to show person, building, and projects drop downs
 * Created by Jan_R on 07/05/2017.
 */
public class Lookup implements Serializable {
    private Long id;
    private String name;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lookup lookup = (Lookup) o;

        if (!getId().equals(lookup.getId())) return false;
        return getName().equals(lookup.getName());

    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getName().hashCode();
        return result;
    }
}
