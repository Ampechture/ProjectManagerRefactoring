package com.ngu.restclienttemplate.MainCode.entity;

import jakarta.persistence.*;
import com.ngu.restclienttemplate.entity.User;
import lombok.Data;

import java.util.List;
@Entity
@Data
@Table(name = "tasks")
public class Task {




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String projectName;

    @ManyToMany
    @JoinTable(
            name="tasksUser ",
            joinColumns = @JoinColumn(name="task_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    public List<User> usersIdentity;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<Subtask> subtasks;


}

