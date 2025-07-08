package com.example.demo.services;

import com.example.demo.models.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class HelloWorldService {

    @Autowired
    EmployeeRepository empRepo;

    public List<Employee> getMethod(){
        return empRepo.findAll();
    }

    public Employee getMethodById(int empId) {
        return empRepo.findById(empId).orElse(new Employee());
    }

    public List<Employee> getMethodByRole(String role) {
        return empRepo.findByRole(role);
    }



    public String postMethod(Employee employee) {
        empRepo.save(employee);
        return "Employee added successfully";
    }

    public String putMethod(Employee employee) {
        empRepo.save(employee);
        return "Employee updated successfully";
    }

    public String deleteMethod(int empId) {
        empRepo.deleteById(empId);
        return "Employee deleted successfully";
    }
}