package com.example.employeespringboot.repository;

import com.example.employeespringboot.models.Employee;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository <Employee,Integer>{

    List<Employee> findByRole(String role);
}