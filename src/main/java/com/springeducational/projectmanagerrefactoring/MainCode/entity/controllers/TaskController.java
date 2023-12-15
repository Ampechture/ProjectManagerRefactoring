package com.springeducational.projectmanagerrefactoring.MainCode.entity.controllers;


import com.springeducational.projectmanagerrefactoring.MainCode.entity.*;
import com.springeducational.projectmanagerrefactoring.MainCode.entity.repository.TaskRepository;
import com.springeducational.projectmanagerrefactoring.auth.UserService;
import com.springeducational.projectmanagerrefactoring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;


@Controller
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(Model model) {
        Long userId = userService.getUserId();
        User user = userService.userFindById(userId);
        List<Task> tasks = taskRepository.findAllByusersIdentity(user);
        model.addAttribute("tasks", tasks);
        model.addAttribute("newTask", new Task());
        model.addAttribute("newSubtask", new Subtask());
        return "index";
    }
}
