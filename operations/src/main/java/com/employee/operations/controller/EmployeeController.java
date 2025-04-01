package com.employee.operations.controller;

import com.employee.operations.entity.Employee;
import com.employee.operations.repos.EmployeeRepo;
import com.employee.operations.service.EmployeeOperations;
import com.employee.operations.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeOperations employeeOperations;

    @PostMapping("/save")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeOperations.saveEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<>(employeeOperations.getALlEmployee(), HttpStatus.OK);
    }

    @GetMapping("/get/id")
    public ResponseEntity<Employee> getEmpById(@RequestParam("id") Long empId) {
        return new ResponseEntity<>(employeeOperations.getEmpById(empId), HttpStatus.OK);
    }

    @DeleteMapping("delete/id")
    public ResponseEntity<Void> deleteEmp(@RequestParam("id") Long empId) {
        employeeOperations.deleteEmp(empId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping("update/id")
    public ResponseEntity<Employee> updateEmp(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeOperations.updateEmp(employee), HttpStatus.CREATED);
    }

}
