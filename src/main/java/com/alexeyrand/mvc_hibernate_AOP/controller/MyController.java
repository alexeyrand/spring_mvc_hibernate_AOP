package com.alexeyrand.mvc_hibernate_AOP.controller;

import com.alexeyrand.mvc_hibernate_AOP.dao.EmployeeDAO;
import com.alexeyrand.mvc_hibernate_AOP.entity.Employee;
import com.alexeyrand.mvc_hibernate_AOP.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/")
    public String showAllEmployees(Model model){

        List<Employee> allEmployees = employeeService.getAllEmployees();
        model.addAttribute("allEmps", allEmployees);
        return "all-employees";
    }
}
