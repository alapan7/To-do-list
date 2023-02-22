package com.example.ToDoList.repository;

import com.example.ToDoList.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Integer> {
    List<Project> findByProjectName(String projectName);
}
