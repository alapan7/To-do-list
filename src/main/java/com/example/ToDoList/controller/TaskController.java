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
    public Optional<Task> findByEmpId(@PathVariable int empId){
        return taskServiceObject.displayByEmpId(empId);
    }

    @GetMapping("/findByMail/{email}")
    public Optional<Task> findByEmpMail(@PathVariable String email){
        return taskServiceObject.displayByEmpMail(email);
    }

    @GetMapping("/findByName/{name}")
    public List<Task> findByEmpName(@PathVariable String name){
        return taskServiceObject.displayByEmpName(name);
    }

    @GetMapping("/displayRecord")
    public List<Task> findAllTask(){
        return taskServiceObject.displayAllTaskDetails();
    }

    @DeleteMapping("/deleteById/{empId}")
    public String deleteByEmpId(@PathVariable int empId){
        taskServiceObject.deleteByEmpId(empId);
        return "Deleted by id";
    }

    @PutMapping("/update/{empId}")
    public String UpdateTask(@PathVariable int empId, @RequestBody Task taskObject){
        return taskServiceObject.UpdateTask(empId,taskObject);
    }


}
