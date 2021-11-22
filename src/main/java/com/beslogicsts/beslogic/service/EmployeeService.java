package com.beslogicsts.beslogic.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beslogicsts.beslogic.model.Employee;
import com.beslogicsts.beslogic.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

        @Autowired
        EmployeeRepository employeeRepository;


        public List<Employee> getAllEmployees()
        {
            List<Employee> employees = new ArrayList<Employee>();
            employeeRepository.findAll().forEach(employees1 -> employees.add(employees1));
            return employees;
        }

        public Employee getEmployeeById(int id)
        {
            return employeeRepository.findById(id).get();
        }

        public void saveOrUpdate(Employee employees)
        {
            employeeRepository.save(employees);
        }

        public void delete(int id)
        {
            employeeRepository.deleteById(id);
        }

        public void update(Employee employees, int employeeid)
        {
            employeeRepository.save(employees);
        }

    }
