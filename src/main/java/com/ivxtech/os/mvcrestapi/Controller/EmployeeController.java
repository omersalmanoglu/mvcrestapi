package com.ivxtech.os.mvcrestapi.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ivxtech.os.mvcrestapi.Model.Employee;


@RestController
public class EmployeeController {

    @GetMapping("/employee")
    public Optional <Employee> getEmployee(@RequestParam(value="id") long  id) {
        List<Employee> empls = getListOfEmployees();
        return empls.stream().filter(employee -> employee.getId() == id).findFirst();
    }
    

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return getListOfEmployees();
    }


    public List<Employee> getListOfEmployees() {
        return List.of(new Employee(1,"Ömer Salmanoğlu",43,100.1),
                        new Employee(2,"Kübra Durkaya Salmanoğlu",39,20.01),
                        new Employee(3,"Derin Salmanoğlu",18,39.48),
                        new Employee(4,"Abdullah Salmanoğlu",46,201.1));
    }

}
