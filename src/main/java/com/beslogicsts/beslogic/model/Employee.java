package com.beslogicsts.beslogic.model;

import javax.persistence.Column;
import javax.validation.constraints.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="employee")
public class Employee {
    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Column
    @NotNull(message = "Name may not be null")
    @Size(min = 2, max=30, message = "Enter at least 2 Characters to 30 Characters")
    private String name;

    @Column
    @NotNull(message = "Department may not be null")
    @Size(min = 2, max=30, message = "Enter at least 2 Characters to 30 Characters")    
    private String department;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
