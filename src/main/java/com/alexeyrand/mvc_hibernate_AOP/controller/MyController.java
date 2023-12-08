package com.alexeyrand.mvc_hibernate_AOP.controller;

import com.alexeyrand.mvc_hibernate_AOP.dao.EmployeeDAO;
import com.alexeyrand.mvc_hibernate_AOP.entity.Employee;
import com.alexeyrand.mvc_hibernate_AOP.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/")
    public String showAllEmployees(Model model){
        System.out.println("Получаем список всех сотрудников (Контроллер)");
        List<Employee> allEmployees = employeeService.getAllEmployees();
        model.addAttribute("allEmps", allEmployees);
        return "all-employees";
    }

    @RequestMapping("/addNewEmployee")
    public String addNewEmployee(Model model) {
        System.out.println("Добавляем нового сотрудника (Контроллер)");
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employee-info";
    }

    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        System.out.println("Cохраняем информацию работника (контроллер)");
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @RequestMapping("/updateInfo")
    public String UpdateEmployee(@RequestParam("empId") int id, Model model) {
        System.out.println("Обновляем работника (контроллер)");
        Employee employee = employeeService.getEmployee(id);
        System.out.println("ya tut");
        model.addAttribute("employee", employee);
        return "employee-info";
    }

    @RequestMapping("/deleteEmployee")
    public String DeleteEmployee(@RequestParam("empId") int id, Model model) {
        System.out.println("Удаляем работника (контроллер)");
        Employee employee = employeeService.getEmployee(id);
        model.addAttribute("employee", employee);
        employeeService.deleteEmployee(id);
        return "redirect:/";
    }
}
