package com.test.demo.services;

import com.test.demo.entities.Project;
import com.test.demo.exceptions.EntityNotFoundException;
import com.test.demo.repos.ProjectRepo;
import jakarta.persistence.EntityExistsException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    // Implement the methods defined in the ProjectService interface
    @Autowired
    private ProjectRepo projectRepo;


    @Transactional
    @Override
    public Project addProject(Project project) {
          // This method will save the project to the database
        return projectRepo.save(project);
    }

    @Transactional

    @Override
    public Project updateProject(Long id, Project project) {
        // This method will update the project with the given id
        Project existingProject = projectRepo.findById(id).orElseThrow(EntityExistsException::new);
        existingProject.setName(project.getName());
        existingProject.setStartDate(project.getStartDate());
        existingProject.setEmployees(project.getEmployees());
        return projectRepo.save(existingProject);



        }

    @Override
    public List<Project> listAllProjects() {
        // This method will return a list of all projects
        if (projectRepo != null) {
            return projectRepo.findAll();
        }
        // If projectRepo is null, return an empty list
        else {
            return List.of();
        }
    }

    @Override
    public Project findProjectById(Long id) {
        // This method will find a project by its id
        return projectRepo.findById(id).orElseThrow(EntityNotFoundException::new);

}

    @Override
    public List<Project> findProjectsByEmployeeId(Long employeeId) throws EntityNotFoundException {
        // This method will find projects by employee id
    if (projectRepo != null) {
            return projectRepo.findByEmployeesId(employeeId);
        }
    // If projectRepo is null, return an empty list
        else {
            throw new EntityNotFoundException("No projects found for employee with id: " + employeeId);
        }
    }

}

