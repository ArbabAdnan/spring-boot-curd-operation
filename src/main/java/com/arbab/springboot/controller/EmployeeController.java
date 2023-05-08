package com.arbab.springboot.controller;

import com.arbab.springboot.exception.ResourceNotFoundException;
import com.arbab.springboot.model.Employee;
import com.arbab.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/emp")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not exit wit id:"+ id));
        return ResponseEntity.ok(employee);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employee){
        Employee updateEmployee=employeeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Employee not exit with id: "+id));
        updateEmployee.setFirstname(employee.getFirstname());
        updateEmployee.setLastname(employee.getLastname());
        updateEmployee.setEmailId(employee.getLastname());

        employeeRepository.save(updateEmployee);
        return ResponseEntity.ok(updateEmployee);
    }
}
