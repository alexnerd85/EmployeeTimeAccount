/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alexnerd.employeetimeaccount.controller;

import com.alexnerd.employeetimeaccount.data.employee.Employee;
import com.alexnerd.employeetimeaccount.utils.EmployeeSupport;
import java.time.LocalDate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Aleksey
 */
@Controller
public class MainController {

    @RequestMapping(value="/main")
    public ModelAndView getTestJsp(){
        ModelAndView model = new ModelAndView("main");
        model.addObject("employees", EmployeeSupport.getEmployees());
        return model;
    }
   
}
