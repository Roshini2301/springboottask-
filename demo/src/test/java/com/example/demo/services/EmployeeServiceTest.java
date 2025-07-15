package com.example.demo.services;

import com.example.demo.models.RegisterDetails;
import com.example.demo.models.UserDetailsDto;
import com.example.demo.repository.RegisterDetailsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

class EmployeeServiceTest {

    @Mock
    RegisterDetailsRepository registerDetailsRepository;

    @InjectMocks
    EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void testGetAllEmployees() {
        RegisterDetails emp1 = new RegisterDetails();
        RegisterDetails emp2 = new RegisterDetails();
        when(registerDetailsRepository.findAll()).thenReturn(Arrays.asList(emp1, emp2));

        List<RegisterDetails> result = employeeService.getMethod();
        assertEquals(2, result.size());
    }


    @Test
    void testGetEmployeeById_Found() {
        RegisterDetails emp = new RegisterDetails();
        emp.setEmpId(101);
        when(registerDetailsRepository.findById(101)).thenReturn(Optional.of(emp));

        RegisterDetails result = employeeService.getEmployeeById(101);
        assertEquals(101, result.getEmpId());
    }


    @Test
    void testGetEmployeeById_NotFound() {
        when(registerDetailsRepository.findById(999)).thenReturn(Optional.empty());

        RegisterDetails result = employeeService.getEmployeeById(999);
        assertNotNull(result); // returns new RegisterDetails()
        assertNull(result.getName()); // default value check
    }


    @Test
    void testAddEmployee() {
        UserDetailsDto dto = new UserDetailsDto();
        dto.setEmpId(200);
        dto.setName("Test Name");
        dto.setEmail("test@example.com");
        dto.setPassword("test123");
        dto.setUserName("testuser");

        RegisterDetails savedEmp = new RegisterDetails();
        savedEmp.setEmpId(dto.getEmpId());
        savedEmp.setName(dto.getName());
        savedEmp.setEmail(dto.getEmail());
        savedEmp.setPassword(dto.getPassword());
        savedEmp.setUserName(dto.getUserName());

        when(registerDetailsRepository.save(any(RegisterDetails.class))).thenReturn(savedEmp);

        String result = employeeService.addEmployee(dto);
        assertEquals("Employee Added Successfully", result);
    }


    @Test
    void testUpdateEmployee_Found() {
        int empId = 123;
        RegisterDetails existingEmp = new RegisterDetails();
        existingEmp.setEmpId(empId);

        UserDetailsDto dto = new UserDetailsDto();
        dto.setName("Updated Name");

        when(registerDetailsRepository.findById(empId)).thenReturn(Optional.of(existingEmp));
        when(registerDetailsRepository.save(existingEmp)).thenReturn(existingEmp);

        String result = employeeService.updateEmployee(empId, dto);
        assertEquals("Employee Updated Successfully", result);
    }


    @Test
    void testUpdateEmployee_NotFound() {
        int empId = 404;
        UserDetailsDto dto = new UserDetailsDto();
        dto.setName("Not Exist");

        when(registerDetailsRepository.findById(empId)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            employeeService.updateEmployee(empId, dto);
        });

        assertEquals("No Such User Present", exception.getMessage());
    }


    @Test
    void testDeleteEmployee() {
        int empId = 123;
        doNothing().when(registerDetailsRepository).deleteById(empId);

        String result = employeeService.deleteEmployeeById(empId);
        assertEquals("Employee Deleted Successfully", result);
    }
}
