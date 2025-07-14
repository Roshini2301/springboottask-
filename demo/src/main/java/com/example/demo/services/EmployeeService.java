package com.example.demo.services;

import com.example.demo.models.RegisterDetails;
import com.example.demo.models.UserDetailsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    com.example.demo.repository.RegisterDetailsRepository registerDetailsRepository;


    public List<RegisterDetails> getMethod() {
        return registerDetailsRepository.findAll();
    }

    public RegisterDetails getEmployeeById(int empId) {
        return registerDetailsRepository.findById(empId).orElse(new RegisterDetails());
    }

//    public List<RegisterDetails> getEmployeeByJob() {
//        return registerDetailsRepository.findByRole();
//    }

//    public String addEmployee(UserDetailsDto employee) {
//        registerDetailsRepository.save(employee);
//        return "Employee Added Successfully";
//    }
public String addEmployee(UserDetailsDto employeeDto) {
    RegisterDetails employee = new RegisterDetails();

    employee.setEmpId(employeeDto.getEmpId()); // Optional if empId is auto-generated
    employee.setName(employeeDto.getName());
    employee.setEmail(employeeDto.getEmail());
    employee.setPassword(employeeDto.getPassword());
    employee.setUserName(employeeDto.getUserName());
    // You can handle roleNames if RegisterDetails has a Set<Role>

    registerDetailsRepository.save(employee); // ✅ No error now
    return "Employee Added Successfully";
}


    public String updateEmployee(int empId, UserDetailsDto employee) {
        RegisterDetails user = registerDetailsRepository.findById(empId)
                .orElseThrow(()->new RuntimeException("No Such User Present"));
        registerDetailsRepository.save(user);
        return "Employee Updated Successfully";
    }

    public String deleteEmployeeById(int empID) {
        registerDetailsRepository.deleteById(empID);
        return "Employee Deleted Successfully";
    }
}