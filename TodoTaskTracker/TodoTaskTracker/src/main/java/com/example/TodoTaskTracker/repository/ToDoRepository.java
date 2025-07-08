package com.example.TodoTaskTracker.repository;

import com.example.TodoTaskTracker.model.TodoTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends JpaRepository<TodoTask,Integer> {
    TodoTask findByname(String name);
}
