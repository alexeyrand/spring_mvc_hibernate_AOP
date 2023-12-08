package com.alexeyrand.mvc_hibernate_AOP.dao;

import com.alexeyrand.mvc_hibernate_AOP.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAllEmployees();

    Employee getEmployee(int id);

    void saveEmployee(Employee employee);

    void deleteEmployee(int id);
}
