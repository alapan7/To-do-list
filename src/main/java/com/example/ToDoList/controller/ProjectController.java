package com.example.ToDoList.controller;

import com.example.ToDoList.model.Project;
import com.example.ToDoList.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProjectController {


    @Autowired
    ProjectService projectServiceObject;

    @PostMapping("/addProjectDetails")
    public String addProjectDetails(@RequestBody Project projectObject){
        projectServiceObject.addProjectDetails(projectObject);
        return "Project record added";
    }

    @GetMapping("/findByProjectId/{projectId}")
    public Optional<Project> findByProjectId(@PathVariable int projectId){
        return projectServiceObject.displayByProjectId(projectId);
    }

    @GetMapping("/findByProjectName/{projectName}")
    public List<Project> findByProjectName(@PathVariable String projectName){
        return projectServiceObject.displayByProjectName(projectName);
    }

    @GetMapping("/displayProjectRecord")
    public List<Project> findAllProject(){
        return projectServiceObject.displayAllProject();
    }

    @DeleteMapping("/deleteByProjectId/{projectId}")
    public String deleteByProjectId(@PathVariable int projectId){
        projectServiceObject.deleteByProjectId(projectId);
        return "Project Deleted";
    }

    @PutMapping("/projectUpdate/{projectId}")
    public String updateProject(@PathVariable int projectId,@RequestBody Project projectObject){
        return projectServiceObject.updateProject(projectId,projectObject);
    }


}
