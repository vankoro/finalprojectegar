package com.example.SpringBootHR.controller;

import com.example.SpringBootHR.model.entity.Employee;
import com.example.SpringBootHR.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

//localhost:8080/employee
@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("")
    public String getAllEmployees(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "employees";
    }

    @GetMapping("/search")
    public String searchEmployee(
            @RequestParam(required = false) String searchSurname,
            @RequestParam(required = false) String searchName,
            @RequestParam(required = false) String searchPatronymic,
            @RequestParam(required = false) LocalDate searchDateBirthday,
            @RequestParam(required = false) LocalDate searchDateStartPosition,
            @RequestParam(required = false) Long searchPosition,
            Model model
    ){
        List<Employee> employees = employeeService.filterEmployee(
                searchSurname,
                searchName,
                searchPatronymic,
                searchDateBirthday,
                searchDateStartPosition,
                searchPosition
        );

        model.addAttribute("employees", employees);
        model.addAttribute("searchSurname", searchSurname);
        model.addAttribute("searchPatronymic", searchPatronymic);
        model.addAttribute("searchDateBirthday", searchDateBirthday);
        model.addAttribute("searchDateStartPosition", searchDateStartPosition);
        model.addAttribute("searchPosition", searchPosition);
        return "employees";
    }
}
