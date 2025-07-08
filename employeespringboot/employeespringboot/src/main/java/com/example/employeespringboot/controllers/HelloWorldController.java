package com.example.employeespringboot.controllers;

import com.example.employeespringboot.models.Employee;
import com.example.employeespringboot.services.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/e")
public class HelloWorldController {
    @Autowired
    HelloWorldService hws;
    @GetMapping("/")
    public List<Employee> getMethod(){

        return hws.getMethod();

    }
    @GetMapping("/role/{role}")
    public List<Employee> getMethodByRole(@PathVariable String role){
        return hws.getMethodByRole(role);
    }

    @GetMapping("/{empId}")
    public Employee getMethodById(@PathVariable int empId){
        return hws.getMethodById(empId);
    }

    @PutMapping("/")
    public String putMethod( @RequestBody Employee employee){
        return  hws.updateEmployee(employee);
    }

    @PostMapping("/")
    public String addEmployee(@RequestBody Employee employee){

        hws.addEmployee(employee);
        return "Employee added successfully!!!";
    }

    @DeleteMapping("/{empId}")
    public String deleteMethodById(@PathVariable int empId){
        hws.deleteMethodById(empId);
        return "deleted";
    }
    @DeleteMapping("/")
    public String deleteMethod(){
        hws.deleteMethod();
        return "deleted";
    }
}
