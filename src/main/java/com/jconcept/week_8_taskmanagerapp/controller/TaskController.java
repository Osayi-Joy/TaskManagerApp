package com.jconcept.week_8_taskmanagerapp.controller;


import com.jconcept.week_8_taskmanagerapp.entity.Task;
import com.jconcept.week_8_taskmanagerapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/list")
    public String list(Model model) {

        List<Task> tasks = taskService.findAllByOrderByDateAsc();

        model.addAttribute("tasks", tasks);
        model.addAttribute("today", LocalDate.now());

        return "list";
    }

    @GetMapping("/archive")
    public String archive(Model model) {

        List<Task> tasks = taskService.findAllByOrderByDateDesc();

        model.addAttribute("tasks", tasks);

        return "archive";
    }


    @GetMapping("/listPriority")
    public String listByPriority(Model model) {

        List<Task> tasks = taskService.findAllByOrderByPriorityAsc();

        model.addAttribute("tasks", tasks);
        model.addAttribute("today", LocalDate.now());

        return "list";
    }

    @GetMapping("/archivePriority")
    public String archiveByPriority(Model model) {

        List<Task> tasks = taskService.findAllByOrderByPriorityAsc();

        model.addAttribute("tasks", tasks);

        return "archive";
    }

    @GetMapping("/getOne")
    @ResponseBody
    public Task getOne(Long id) {
        return taskService.getOne(id);
    }

    @PostMapping("/new")
    public String saveItem(Task task, HttpServletRequest request) {

        taskService.save(task);

        String referer = request.getHeader("Referer");

        return "redirect:" + referer;
    }

    @GetMapping("/update")
    public String updateItem(Task task, HttpServletRequest request) {

        taskService.save(task);
        String referer = request.getHeader("Referer");

        return "redirect:" + referer;
    }

    @GetMapping("/delete")
    public String delete(Long id, HttpServletRequest request) {

        taskService.deleteById(id);

        String referer = request.getHeader("Referer");

        return "redirect:" + referer;
    }
}
