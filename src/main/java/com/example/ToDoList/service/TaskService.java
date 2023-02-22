package com.example.ToDoList.service;

import com.example.ToDoList.model.Task;
import com.example.ToDoList.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepositoryObject;

    public void addTaskDetails(Task taskObject){
        taskRepositoryObject.save(taskObject);
    }

    public Optional<Task> displayByEmpId(int empId){
        return taskRepositoryObject.findById(empId);
    }

    public Optional<Task> displayByEmpMail(String email){
        return taskRepositoryObject.findByEmail(email);
    }

    public List<Task> displayByEmpName(String name){
        return taskRepositoryObject.findByName(name);
    }

    public List<Task> displayAllTaskDetails(){
        return taskRepositoryObject.findAll();
    }

    public void deleteByEmpId(int empId){
        taskRepositoryObject.deleteById(empId);
    }


    public String UpdateTask(int empId, Task taskObject) {
        Optional<Task> newTaskObject = taskRepositoryObject.findById(empId);
        if(taskObject!=null)
        {
            taskRepositoryObject.deleteById(empId);
            taskRepositoryObject.save(taskObject);
            return "Updated";
        }
        return "Not Updated";
    }




}
