package com.sahil.SpringJPAHibernateAssignment.services;

import com.sahil.SpringJPAHibernateAssignment.entities.Employee;
import com.sahil.SpringJPAHibernateAssignment.repos.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public Iterable<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Employee updateEmployee(Integer id, Employee newEmployee) {
        employeeRepository.save(newEmployee);
        return newEmployee;
    }

    @Override
    public Employee deleteEmployee(Integer id) {
        Employee deletedEmployee = employeeRepository.findById(id).orElse(null);
         employeeRepository.deleteById(id);
         return  deletedEmployee;
    }

    @Override
    public long getEmployeesCount() {
        return employeeRepository.count();
    }

    @Override
    public List<Employee> getEmployeeByName(String name) {
        return employeeRepository.findByName(name);
    }

    @Override
    public List<Employee> getEmployeeByNameStartingWith(String prefix) {
        return employeeRepository.findByNameStartingWith(prefix);
    }

    @Override
    public List<Employee> getEmployeeByAgeBetween(int age1, int age2) {
        return employeeRepository.findByAgeBetween(age1,age2);
    }

    @Override
    public Iterable<Employee> getEmployeesAgeWise() {
        return employeeRepository.findAll(Sort.by(new Sort.Order(null,"age")));
    }

    @Override
    public Page<Employee> getEmployeesPaged(int page,int size) {

        Pageable pageable = PageRequest.of(page,size);
        return employeeRepository.findAll(pageable);
    }
}

