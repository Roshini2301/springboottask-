package com.example.demo.controllers;

import com.example.demo.models.RegisterDetails;
import com.example.demo.models.UserDetailsDto;
import com.example.demo.services.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/")
    public String route(){
        return "Welcome to SpringBoot Security";
    }


    @GetMapping("/employee")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public List<RegisterDetails> getMethod(){
        return employeeService.getMethod();
    }


    @GetMapping("/employee/{empId}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public RegisterDetails getEmployeeById(@PathVariable int empId){
        System.out.println();
        return employeeService.getEmployeeById(empId);
    }



//    @PreAuthorize("hasAnyRole('ADMIN','USER')")
//    @GetMapping("/employee/job/{job}")
//    public List<RegisterDetails> getEmployeeByJob(@PathVariable String job){
//        return employeeService.getEmployeeByJob(job);
//    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/employee")
    public String postMethod(@RequestBody UserDetailsDto employee){
//        Employee employee = new Employee(5,"Mani", "Business");
        return employeeService.addEmployee(employee);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/employee/{empId}")
    public String putMethod(@PathVariable int empId, @RequestBody UserDetailsDto employee) {
        return employeeService.updateEmployee(empId, employee);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/employee/{empID}")
    public String deleteMethod(@PathVariable int empID){
        return employeeService.deleteEmployeeById(empID);
    }
}