package com.example.demo.controllers;

import com.example.demo.models.Employee;
import com.example.demo.services.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
//@RequestMapping("/e")
public class HelloWorldController {
    @Autowired
    HelloWorldService hws;
    @GetMapping("/")
    public String route(){
        return "Welcome to springboot security";
    }
    @GetMapping("/e")
    public List<Employee> getMethod(){
        return hws.getMethod();
    }
    @GetMapping("/e/{empId}")
    public Employee getMethodById(@PathVariable int empId){
        return hws.getMethodById(empId);
    }
    @GetMapping("/e/role/{role}")
    public List<Employee> getMethodByRole(@PathVariable String role){
        return hws.getMethodByRole(role);
    }
    @PutMapping("/e")
    public String putMethod( @RequestBody Employee employee){
        return  hws.putMethod(employee);
    }
    @PostMapping("/e")
    public String postMethod(@RequestBody Employee employee){
        return hws.postMethod(employee);
    }
    @DeleteMapping("/e/{empId}")
    public String deleteMapping(@PathVariable int empId){
        return hws.deleteMethod(empId);
    }
}