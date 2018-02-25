/*
 *   Created on : 21.02.2018, 19:06:34
 *   Author     : Popov Aleksey
 *   Site       : alexnerd.com
 *   Email      : alexnerd85@gmail.com
 *   GitHub     : https://github.com/alexnerd85/EmployeeTimeAccount
 */

package com.alexnerd.employeetimeaccount.controller;

import com.alexnerd.employeetimeaccount.daoServices.EmployeeDAOService;
import com.alexnerd.employeetimeaccount.data.Employee;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("employee")
public class EmployeeRESTController {
    
    @Autowired(required=true)
    @Qualifier("employeeDAOService")
    private EmployeeDAOService employeeDAOService;
    
    @PostMapping(value="add")
    public boolean add(@RequestBody Employee employee){
        employeeDAOService.addEmployee(employee);
        return true;
    }
    @GetMapping(value="getall", produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> getAll(){
        return employeeDAOService.getAllEmployees();
    }
    
    @GetMapping(value="getbyid", produces=MediaType.APPLICATION_JSON_VALUE)
    public Employee getById(@RequestParam("id") Long id){
        return employeeDAOService.getEmployeeById(id);
    }
    
    @GetMapping(value="search", produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> search(@RequestParam("q") String query){
        return employeeDAOService.search(query);
    }
    
    @GetMapping(value="get", produces=MediaType.APPLICATION_JSON_VALUE)
    public boolean get(){
        return true;
    }
    
}
