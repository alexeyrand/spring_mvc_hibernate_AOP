package com.alexeyrand.mvc_hibernate_AOP.service;

import com.alexeyrand.mvc_hibernate_AOP.dao.EmployeeDAO;
import com.alexeyrand.mvc_hibernate_AOP.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

}
