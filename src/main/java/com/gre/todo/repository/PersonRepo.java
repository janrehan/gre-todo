package com.gre.todo.repository;

import com.gre.todo.model.Building;
import com.gre.todo.model.Person;
import com.gre.todo.model.Project;
import com.gre.todo.model.ProjectProgress;

import java.util.List;

/**
 * Created by Jan_R on 14/05/2017.
 */
public interface PersonRepo {

    public void savePerson(Person person);

    public List<Person> getAllPersons();

    public Person getPersonByEmail(String email);

    public int removePersonByEmail(String email);
}
