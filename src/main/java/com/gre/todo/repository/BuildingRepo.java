package com.gre.todo.repository;

import com.gre.todo.model.Building;

import java.util.List;

/**
 * Created by Jan_R on 15/05/2017.
 */
public interface BuildingRepo {

    public void saveBuilding(Building building);

    public List<Building> getAllBuildings();

}
