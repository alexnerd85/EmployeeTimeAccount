/*
 *   Created on : 28.01.2018, 23:09:24
 *   Author     : Popov Aleksey
 *   Site       : alexnerd.com
 *   Email      : alexnerd85@gmail.com
 *   GitHub     : https://github.com/alexnerd85/EmployeeTimeAccount
 */

package com.alexnerd.employeetimeaccount.controller;

import com.alexnerd.employeetimeaccount.data.Employee;
import com.alexnerd.employeetimeaccount.services.EmployeeService;
import com.alexnerd.employeetimeaccount.utils.EmployeeSupport;
import java.time.LocalDate;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MainController {
    
    @Autowired(required=true)
    @Qualifier("employeeService")
    private EmployeeService employeeService;

    //@RequestMapping(value="/app/main")
    @RequestMapping(value="/")
    public ModelAndView getTestJsp(){
        ModelAndView model = new ModelAndView("app/main");
        employeeService.addEmployee("Меня");
        model.addObject("employees", EmployeeSupport.getEmployees());
        return model;
    }
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:login?logout";
    }
   
}
