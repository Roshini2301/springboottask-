package com.example.student.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private int rollno;
    private String name;
    private String dept;
}