package com.example.ToDoList.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Task {

    @Id
    private int empId;
    private String name;
    private String email;
    private String company;
    private String officeWork;
    private float officeTiming;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "projectId")
    Project projectObject;
}

