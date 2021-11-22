package com.beslogicsts.beslogic.repository;

import org.springframework.data.repository.CrudRepository;

import com.beslogicsts.beslogic.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>
    {

    }

