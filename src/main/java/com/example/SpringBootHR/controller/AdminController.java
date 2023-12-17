package com.example.SpringBootHR.controller;

import com.example.SpringBootHR.model.entity.Employee;
import com.example.SpringBootHR.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public String getAdminEmployeePage(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        model.addAttribute("positions", employeeService.getAllPosition());
        model.addAttribute("employee", new Employee());
        return "adminPage";
    }

    @PostMapping("/employee/addEmployee")
    public String addNewUser(@ModelAttribute("employee") @Valid Employee employee, BindingResult bliBindingResult) {
        employeeService.createEmployee(employee);
        return "redirect:/admin/employee";
    }

    @GetMapping("/employee/delete/{id}")
    public String deleteEmployee(@PathVariable long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/admin/employee";
    }

    @GetMapping("/employee/search")
    public String searchEmployee(
            @RequestParam(required = false) String searchSurname,
            @RequestParam(required = false) String searchName,
            @RequestParam(required = false) String searchPatronymic,
            @RequestParam(required = false) LocalDate searchDateBirthday,
            @RequestParam(required = false) LocalDate searchDateStartPosition,
            @RequestParam(required = false) Long searchPosition,
            Model model
    ) {
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
        return "adminPage";
    }

}
