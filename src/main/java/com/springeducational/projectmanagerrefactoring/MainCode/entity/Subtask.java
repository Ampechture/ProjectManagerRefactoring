package com.springeducational.projectmanagerrefactoring.MainCode.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "subtasks")
public class Subtask {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Task getProject() {
        return project;
    }

    public void setProject(Task project) {
        this.project = project;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String taskName;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Task project;
    
}
