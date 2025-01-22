package kz.bitlab.practiceTask.controller;

import kz.bitlab.practiceTask.model.Task;
import kz.bitlab.practiceTask.service.TaskDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TaskController {

    @Autowired
    private TaskDB taskDB;

    @GetMapping(value = "/tasks")
    public String getTasks(Model model){
        model.addAttribute("tasktar", taskDB.getTaskList());
        return "main";
    }

    @GetMapping(value = "/detailsTask/{id}")
    public String getTask(@PathVariable(value = "id") Long id,
                          Model model){
        model.addAttribute("zadacha", taskDB.getTask(id));
        return "detailsTask";
    }

    @PostMapping(value = "/update/{id}")
    public String updateTask(@RequestParam(name = "taskName") String taskName,
                             @RequestParam(name = "taskDeadline") String taskDeadline,
                            @PathVariable(value = "id") Long taskId,
                             @RequestParam(name = "isComplete") boolean taskIsComplete
    ) {

        taskDB.updateTask(taskId, taskName, taskDeadline, taskIsComplete);
        return "redirect:/tasks";
    }
}
