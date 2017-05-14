package com.gre.todo;

import com.gre.todo.model.ProjectProgress;
import com.gre.todo.repository.ProjectProgressRepo;
import com.gre.todo.repository.ProjectProgressRepoImpl;
import junit.framework.TestCase;

import java.util.List;

/**
 * Created by Jan_R on 5/5/2017.
 */
public class TestProjectProgressRepo extends TestCase {
    public void testAppRepo() {
        ProjectProgressRepo projectProgressRepo = new ProjectProgressRepoImpl();
        List<ProjectProgress> projectProgressResult = projectProgressRepo.findProjectProgressBy(1L, null, null);
        System.out.println("done");
    }
}