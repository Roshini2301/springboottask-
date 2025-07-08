package com.example.employeespringboot.services;

import com.example.employeespringboot.models.Employee;
import com.example.employeespringboot.repository.EmployeeRepository;
import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class HelloWorldService {

    @Autowired
    EmployeeRepository empRepo;
    public List<Employee> getMethod(){
        return empRepo.findAll();
    }
    public Employee getMethodById(int empId){
        return empRepo.findById(empId).orElse(new Employee());
    }

    public List<Employee> getMethodByRole(String role) {
        return empRepo.findByRole(role);
    }

    public String addEmployee(Employee employee){
        empRepo.save(employee);
        return "Employee added successfully!!!!";
    }
    public String updateEmployee(Employee employee){
        empRepo.save(employee);
        return "Employee updated successfully";

    }
    public String deleteMethodById(int id){
        empRepo.deleteById(id);
        return "deleted ";
    }
    public String deleteMethod(){
        empRepo.deleteAll();
        return "deleted ";
    }



}