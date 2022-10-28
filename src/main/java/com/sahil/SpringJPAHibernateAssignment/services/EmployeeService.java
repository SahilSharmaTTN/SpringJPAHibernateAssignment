package com.sahil.SpringJPAHibernateAssignment.services;

import com.sahil.SpringJPAHibernateAssignment.entities.Employee;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface EmployeeService {

    public Employee createEmployee(Employee employee);

    public Iterable<Employee> getAllEmployees();

    public Employee getEmployeeById(Integer id);

    public Employee updateEmployee(Integer id, Employee newEmployee);

    public Employee deleteEmployee(Integer id);

    public long getEmployeesCount();

    public List<Employee> getEmployeeByName(String name);

    public List<Employee> getEmployeeByNameStartingWith(String prefix);

    public List<Employee> getEmployeeByAgeBetween(int age1, int age2);

    public Iterable<Employee> getEmployeesAgeWise();

    public Page<Employee> getEmployeesPaged(int page,int size);

}
