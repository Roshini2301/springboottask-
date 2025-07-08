package com.example.TodoTaskTracker.controllers;

import com.example.TodoTaskTracker.model.TodoTask;
import com.example.TodoTaskTracker.services.TodoTaskServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TodoTaskController {
    @Autowired
    private TodoTaskServices tts;

    @PostMapping
    public String CreateTask(@RequestBody TodoTask task){
        String addtask = tts.AddTask(task);
        return  addtask;
    }

    @GetMapping
    public List<TodoTask> readAllTasks(){
        return tts.ShowAllTasks();
    }

    @GetMapping("/{id}")
    public TodoTask readTaskByid(@PathVariable int id) {
        return tts.ShowTaskById(id);
    }

    @GetMapping("/name/{name}")
    public TodoTask readTaskByName(@PathVariable String name){
        return tts.readTaskByName(name);
    }

    @PutMapping
    public String UpdateTaskByid(@RequestBody TodoTask task){
        return tts.UpdateTaskById(task);
    }

    @DeleteMapping
    public String DeleteAllTask(){
        return tts.DeleteAllTask();
    }

    @DeleteMapping("/{id}")
    public String DeleteTaskByid(@PathVariable int id){
        return tts.DeleteTaskById(id);
    }

}
