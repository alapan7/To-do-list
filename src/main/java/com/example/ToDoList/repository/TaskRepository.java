package com.example.ToDoList.repository;

import com.example.ToDoList.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task,Integer> {
    List<Task> findByName(String name);

    Optional<Task> findByEmail(String email);

    List<Task> findByProjectName(String project);
}
