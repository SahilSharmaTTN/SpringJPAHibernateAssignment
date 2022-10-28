package com.sahil.SpringJPAHibernateAssignment.repos;

import com.sahil.SpringJPAHibernateAssignment.entities.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Integer> {

    public List<Employee> findByName(String name);

    public List<Employee> findByNameStartingWith(String prefix);

    public List<Employee> findByAgeBetween(int age1,int age2);



}
