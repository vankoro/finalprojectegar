package com.example.SpringBootHR.service;

import com.example.SpringBootHR.model.EmployeeRepo;
import com.example.SpringBootHR.model.entity.Employee;
import com.example.SpringBootHR.model.entity.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    public List<Employee> getAllEmployees(){
        return employeeRepo.findAll();
    }

    public List<Position> getAllPosition(){ return employeeRepo.getAllPosition();}

    public void createEmployee(Employee employee){
        employeeRepo.save(employee);
    }

    public List<Employee> getEmployeesByNamePosition(String namePosition){
        return employeeRepo.getEmployeesByPositionName(namePosition);
    }

    public void deleteEmployee(long id){
        employeeRepo.deleteById(id);
    }

    public List<Employee> filterEmployee(String surname, String name, String patronymic, LocalDate dateBirthday, LocalDate dateStartPosition, Long idPosition){
        List<Employee> employees = employeeRepo.findAll();

        if (surname != null && !surname.isEmpty()){
            ArrayList<Employee> temp = new ArrayList<>();
            for (Employee employee : employees) {
                if (employee.getSurname().toLowerCase().startsWith(surname.toLowerCase())){
                    temp.add(employee);
                }
            }

            employees = temp;
        }

        if (name != null && !name.isEmpty()){
            ArrayList<Employee> temp = new ArrayList<>();
            for (Employee employee : employees) {
                if (employee.getName().toLowerCase().startsWith(name.toLowerCase())){
                    temp.add(employee);
                }
            }

            employees = temp;
        }

        if (patronymic != null && !patronymic.isEmpty()){
            ArrayList<Employee> temp = new ArrayList<>();
            for (Employee employee : employees) {
                if (employee.getPatronymic().toLowerCase().startsWith(patronymic.toLowerCase())){
                    temp.add(employee);
                }
            }

            employees = temp;
        }

        if (dateBirthday != null){
            ArrayList<Employee> temp = new ArrayList<>();
            for (Employee employee : employees) {
                if (employee.getDateBirthday().equals(dateBirthday)){
                    temp.add(employee);
                }
            }
            employees = temp;
        }

        if (dateStartPosition != null){
            ArrayList<Employee> temp = new ArrayList<>();
            for (Employee employee : employees) {
                if (employee.getDateStartPosition().equals(dateStartPosition)){
                    temp.add(employee);
                }
            }
            employees = temp;
        }

        if (idPosition != null){
            ArrayList<Employee> temp = new ArrayList<>();
            for (Employee employee : employees) {
                if (employee.getPosition().getId() == idPosition){
                    temp.add(employee);
                }
            }
            employees = temp;
        }
        return employees;
    }
}
