package com.example.ToDoList.controller;

import com.example.ToDoList.model.Task;
import com.example.ToDoList.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {

    @Autowired
    TaskService taskServiceObject;

    @PostMapping("/addTaskDetails")
    public String addTaskDetails(@RequestBody Task taskObject){
        taskServiceObject.addTaskDetails(taskObject);
                return "Task record added";
    }

    @GetMapping("/findById/{empId}")
    public Optional<Task> findById(@PathVariable int empId){
        return taskServiceObject.displayById(empId);
    }

    @GetMapping("/findByMail/{email}")
    public Optional<Task> findByMail(@PathVariable String email){
        return taskServiceObject.displayByMail(email);
    }

    @GetMapping("/findByName/{name}")
    public List<Task> findByName(@PathVariable String name){
        return taskServiceObject.displayByName(name);
    }

    @GetMapping("/findByProject/{project}")
    public List<Task> findByProject(@PathVariable String project){
        return taskServiceObject.displayByProject(project);
    }

    @GetMapping("/displayRecord")
    public List<Task> findAll(){
        return taskServiceObject.displayAllTaskDetails();
    }

    @DeleteMapping("/deleteById/{empId}")
    public String deleteById(@PathVariable int empId){
        taskServiceObject.deleteById(empId);
        return "Deleted by id";
    }

    @PutMapping("/update/{id}")
    public String Update(@PathVariable int id, @RequestBody Task taskObject){
        return taskServiceObject.Update(id,taskObject);
    }


}
