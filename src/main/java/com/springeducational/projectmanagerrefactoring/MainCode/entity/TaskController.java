package com.ngu.restclienttemplate.MainCode.entity.controllers;



import com.ngu.restclienttemplate.MainCode.entity.*;
import com.ngu.restclienttemplate.MainCode.entity.repository.TaskRepository;
import com.ngu.restclienttemplate.auth.UserService;
import com.ngu.restclienttemplate.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


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