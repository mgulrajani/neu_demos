package com.test.demo.services;

import com.test.demo.entities.Project;
import com.test.demo.exceptions.EntityNotFoundException;

import java.util.List;

public interface ProjectService {

    // This service will be used by the controller to manage projects
    // Define methods for adding, updating, listing, and finding projects

    public Project addProject(Project project);
     public Project updateProject(Long id, Project project) throws EntityNotFoundException;
     public List<Project> listAllProjects();
     public Project findProjectById(Long id) throws EntityNotFoundException;

}
