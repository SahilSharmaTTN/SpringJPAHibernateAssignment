package com.sahil.SpringJPAHibernateAssignment.controller;

import com.sahil.SpringJPAHibernateAssignment.entities.Employee;
import com.sahil.SpringJPAHibernateAssignment.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public Iterable<Employee> getEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeesById(@PathVariable Integer id){
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){
        employeeService.createEmployee(employee);
        return employee;
    }

    @GetMapping("/employees/count")
    public long getEmployeesCount(){
        return employeeService.getEmployeesCount();
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable Integer id,@RequestBody Employee employee){
        return employeeService.updateEmployee(id,employee);
    }


    @GetMapping("/employees/name/{name}")
    public List<Employee> getEmployeeByName(@PathVariable String name){
        return employeeService.getEmployeeByName(name);
    }


    @GetMapping("/employees/nameLike/{prefix}")
    public List<Employee> getEmployeesByNameLike(@PathVariable String prefix){
        return employeeService.getEmployeeByNameStartingWith(prefix);
    }


    @GetMapping("employees/age/{age1}/{age2}")
    public List<Employee> getEmployeesByAgeBetween(@PathVariable("age1") int age1,@PathVariable("age2") int age2){
        return employeeService.getEmployeeByAgeBetween(age1,age2);
    }


    @GetMapping("employees/ageSorted")
    public Iterable<Employee> getEmployeesSortedByAge(){
        return employeeService.getEmployeesAgeWise();
    }


    @GetMapping("employeesPaged/{page}/{size}")
    public Page<Employee> getAllEmployeesPaged(@PathVariable("page") int page,@PathVariable("size")int size){
        return employeeService.getEmployeesPaged(page,size);
    }


}
