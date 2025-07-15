package com.example.demo.controllers;

import com.example.demo.models.RegisterDetails;
import com.example.demo.models.UserDetailsDto;
import com.example.demo.services.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class EmployeeControllerTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeController employeeController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRoute() {
        String result = employeeController.route();
        assertEquals("Welcome to SpringBoot Security", result);
    }

    @Test
    void testGetAllEmployees() {
        RegisterDetails emp1 = new RegisterDetails();
        RegisterDetails emp2 = new RegisterDetails();
        when(employeeService.getMethod()).thenReturn(Arrays.asList(emp1, emp2));
        List<RegisterDetails> result = employeeController.getMethod();
        assertEquals(2, result.size());
    }

    @Test
    void testGetEmployeeById() {
        RegisterDetails emp = new RegisterDetails();
        emp.setEmpId(101); // assuming `setId()` exists
        when(employeeService.getEmployeeById(101)).thenReturn(emp);

        RegisterDetails result = employeeController.getEmployeeById(101);
        assertEquals(101, result.getEmpId());
    }

    @Test
    void testAddEmployee() {
        UserDetailsDto newEmp = new UserDetailsDto();
        newEmp.setUserName("John"); // assuming setters exist
        newEmp.setJob("Developer");

        when(employeeService.addEmployee(newEmp)).thenReturn("Employee added successfully");

        String result = employeeController.postMethod(newEmp);
        assertEquals("Employee added successfully", result);
    }

    @Test
    void testUpdateEmployee() {
        UserDetailsDto updateEmp = new UserDetailsDto();
        updateEmp.setUserName("Jane"); // assuming setters exist
        updateEmp.setJob("Manager");

        when(employeeService.updateEmployee(101, updateEmp)).thenReturn("Employee updated");

        String result = employeeController.putMethod(101, updateEmp);
        assertEquals("Employee updated", result);
    }

    @Test
    void testDeleteEmployee() {
        when(employeeService.deleteEmployeeById(101)).thenReturn("Employee deleted");

        String result = employeeController.deleteMethod(101);
        assertEquals("Employee deleted", result);
    }
}
