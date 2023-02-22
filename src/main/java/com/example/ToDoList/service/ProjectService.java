package com.example.ToDoList.service;

import com.example.ToDoList.model.Project;
import com.example.ToDoList.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepositoryObject;

    public void addProjectDetails(Project projectObject){
        projectRepositoryObject.save(projectObject);
    }

    public Optional<Project> displayByProjectId(int projectId){
        return projectRepositoryObject.findById(projectId);
    }

    public List<Project> displayByProjectName(String projectName){
        return projectRepositoryObject.findByProjectName(projectName);
    }

    public List<Project> displayAllProject(){
        return projectRepositoryObject.findAll();
    }

    public void deleteByProjectId(int projectId){
        projectRepositoryObject.deleteById(projectId);
    }

    public String updateProject(int projectId,Project projectObject){
        Optional<Project> newProjectObject = projectRepositoryObject.findById(projectId);
        if(projectObject != null){
            projectRepositoryObject.deleteById(projectId);
            projectRepositoryObject.save(projectObject);
            return "Project Updated";
        }
        return "Project Not Updated";
    }

}
