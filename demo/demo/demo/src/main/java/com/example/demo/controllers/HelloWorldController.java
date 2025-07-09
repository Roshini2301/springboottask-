package com.example.demo.controllers;

import com.example.demo.models.Employee;
import com.example.demo.services.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
//@RequestMapping("/e")
public class HelloWorldController {
    @Autowired
    private HelloWorldService hws;
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/")
    public String route(){
        return "Welcome to springboot security";
    }
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/employee")
    public List<Employee> getMethod(){
        return hws.getMethod();
    }
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/employee/{empId}")
    public Employee getMethodById(@PathVariable int empId){
        return hws.getMethodById(empId);
    }
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/employee/role/{role}")
    public List<Employee> getMethodByRole(@PathVariable String role){
        return hws.getMethodByRole(role);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/employee")
    public String putMethod( @RequestBody Employee employee){
        return  hws.putMethod(employee);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/employee")
    public String postMethod(@RequestBody Employee employee){
        return hws.postMethod(employee);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/employee/{empId}")
    public String deleteMapping(@PathVariable int empId){
        return hws.deleteMethod(empId);
    }
}