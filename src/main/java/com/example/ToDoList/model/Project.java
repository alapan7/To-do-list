package com.example.ToDoList.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Entity
    public class Project {

        @Id
        private int projectId;
        private String projectName;
        private String startingDate;
        private String endingDate;

    }


