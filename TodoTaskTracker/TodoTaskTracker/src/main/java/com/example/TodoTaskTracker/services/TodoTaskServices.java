package com.example.TodoTaskTracker.services;

import com.example.TodoTaskTracker.TodoTaskTrackerApplication;
import com.example.TodoTaskTracker.model.TodoTask;
import com.example.TodoTaskTracker.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TodoTaskServices {

    @Autowired
    private ToDoRepository toDoRepository;

    public String AddTask(TodoTask task){
        toDoRepository.save(task);
        return "Task added successfully";
    }

    public List<TodoTask> ShowAllTasks(){

        return toDoRepository.findAll();
    }
    public TodoTask ShowTaskById(int id){
        return toDoRepository.findById(id).orElse(null);
    }

    public TodoTask readTaskByName(String name) {
        return toDoRepository.findByname(name);
    }

    public String UpdateTaskById(TodoTask task){
        toDoRepository.save(task);
        return "Task updated successfully";
    }
    public String DeleteAllTask(){
        toDoRepository.deleteAll();
        return "All Task deleted succesfully";
    }
    public String DeleteTaskById(int id){
        toDoRepository.deleteById(id);
        return "Task deleted successfully";
}
}
