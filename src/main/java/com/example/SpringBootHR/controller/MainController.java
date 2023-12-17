package com.example.SpringBootHR.controller;

import com.example.SpringBootHR.model.EmployeeRepo;
import com.example.SpringBootHR.model.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {
    //localhost:8080
    @GetMapping("/")
    public String index(){
        return "index";
    }

    //localhost:8080/admin
    @GetMapping("/admin")
    public String adminPage(){
        return "adminPage";
}

    //localhost:8080/print?name=Андрей
    @GetMapping("/print")
    public String printName(Model model, @RequestParam String name){
        System.out.println(name);
        model.addAttribute("name_user", name);
        return "index";
    }

    //localhost:8080/print_name_and_age?name=Андрей&age=27
    @GetMapping("/print_name_and_age")
    public String printNameAndAge(@RequestParam String name, @RequestParam Integer age ){
        System.out.println(name + " " + age);
        return "index";
    }

    //localhost:8080/print_name_and_age_if_need?name=Андрей&age=27
    //localhost:8080/print_name_and_age_if_need?name=Андрей
    @GetMapping("/print_name_and_age_if_need")
    public String printNameAndAgeIfNeed(@RequestParam String name, @RequestParam(required = false) Integer age ){
        System.out.println(name + " " + age);
        return "index";
    }
}
