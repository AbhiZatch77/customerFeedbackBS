package com.employee.operations.service;

import com.employee.operations.entity.Employee;

import java.util.List;

public interface EmployeeOperations {

    List<Employee> getALlEmployee();

    Employee saveEmployee(Employee employee);

    Employee getEmpById(Long empId);

    void deleteEmp(Long empId);

    Employee updateEmp(Employee employee);
}
