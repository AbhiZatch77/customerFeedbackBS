package com.employee.operations.service;

import com.employee.operations.entity.Employee;
import com.employee.operations.repos.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements EmployeeOperations {

    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public List<Employee> getALlEmployee() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public Employee getEmpById(Long empId) {
        return employeeRepo.findById(empId).get();
    }

    @Override
    public void deleteEmp(Long empId) {
        employeeRepo.deleteById(empId);
    }

    @Override
    public Employee updateEmp(Employee employee) {
        return employeeRepo.save(employee);
    }

}
