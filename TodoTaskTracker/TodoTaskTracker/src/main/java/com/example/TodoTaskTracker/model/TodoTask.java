package com.example.TodoTaskTracker.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "todo_task") // Maps to the exact table name in your DB
public class TodoTask {

    @Id
    @Column(name = "task_id") // This ensures correct mapping with DB column
    private int taskId;

    @Column(name = "name") // optional, but good for clarity
    private String name;

    @Column(name = "status") // optional
    private String status;
}
