package com.alexeyrand.mvc_hibernate_AOP.service;

import com.alexeyrand.mvc_hibernate_AOP.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
}

