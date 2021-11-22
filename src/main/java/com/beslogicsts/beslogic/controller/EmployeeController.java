package com.beslogicsts.beslogic.controller;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.beslogicsts.beslogic.model.Employee;
import com.beslogicsts.beslogic.service.EmployeeService;

import java.util.List;

import javax.validation.Valid;

@Controller
public class EmployeeController {


        @Autowired
        EmployeeService employeeService;

//        @GetMapping("/employee")
//        private List<Employee> getAllEmployees()
//        {
//            return employeeService.getAllEmployees();
//        }
//
//        @GetMapping("/employee/{employeeid}")
//        private Employee getEmployees(@PathVariable("employeeid") int employeeid)
//        {
//            return employeeService.getEmployeeById(employeeid);
//        }
//
//        @DeleteMapping("/employee/{employeeid}")
//        private void deleteEmployee(@PathVariable("employeeid") int employeeid)
//        {
//            employeeService.delete(employeeid);
//        }
//
//        @PostMapping("/employees")
//        private int saveEmployee(@RequestBody Employee employees)
//        {
//            employeeService.saveOrUpdate(employees);
//            return employees.getId();
//        }
//
//        @PutMapping("/employees")
//        private Employee update(@RequestBody Employee employees)
//        {
//            employeeService.saveOrUpdate(employees);
//            return employees;
//        }

        @GetMapping("/")
        private String showAllEmployees(Model mod)
        {
            mod.addAttribute("allEmployees", employeeService.getAllEmployees());
            return "showEmployees";
        }

    @RequestMapping("/create-employee")
    public String showCreateEmployeePage(Model model) {
        model.addAttribute("command", new Employee());
        return "createEmployee";
    }
    
    @RequestMapping(value = "/create-employee", method = RequestMethod.POST)
    public String createEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult result) {
    	
    	if(result.hasErrors()) {
//    		if(employee.getName().isEmpty()){
//    		result.rejectValue("name", "error.name");
//    		}
//    		if(employee.getDepartment().isEmpty()){
//    		result.rejectValue("department", "error.department");
//    		}
    		return "redirect:/";
    	}
    	
    	employeeService.saveOrUpdate(employee);
        return "redirect:/";
    }
    
    @RequestMapping(value = "/update-employee/{id}")
    public String showUpdateContactPage(@PathVariable int id, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("command", employeeService.getEmployeeById(id));
        return "updateEmployee";
    }
    
    @RequestMapping(value = "/update-employee/{id}", method = RequestMethod.POST)
    public String updateEmployee(@PathVariable int id,@Valid @ModelAttribute("employee") Employee employee, BindingResult result) {
    	if(result.hasErrors()) {
//    		if(employee.getName().isEmpty()){
//        		result.rejectValue("name", "error.name");
//        		}
//        		if(employee.getDepartment().isEmpty()){
//        		result.rejectValue("department", "error.department");
//        		}
    		return "redirect:/";
    	}
    	employeeService.update(employee, id);
        return "redirect:/";
    }
    
    @RequestMapping("/delete-employee/{id}")
    public String deleteEmployee(@PathVariable int id) {
          employeeService.delete(id);
          return "redirect:/";  
    }
    





    }
