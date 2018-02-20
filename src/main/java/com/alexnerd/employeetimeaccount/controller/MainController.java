/*
 *   Created on : 28.01.2018, 23:09:24
 *   Author     : Popov Aleksey
 *   Site       : alexnerd.com
 *   Email      : alexnerd85@gmail.com
 *   GitHub     : https://github.com/alexnerd85/EmployeeTimeAccount
 */

package com.alexnerd.employeetimeaccount.controller;

import com.alexnerd.employeetimeaccount.utils.EmployeeSupport;
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
import com.alexnerd.employeetimeaccount.daoServices.EmployeeDAOService;
import com.alexnerd.employeetimeaccount.daoServices.UserDAOService;
import com.alexnerd.employeetimeaccount.data.User;
import com.alexnerd.employeetimeaccount.data.User.UserRole;
import java.util.HashSet;
import java.util.Set;


@Controller
public class MainController {
    
    @Autowired(required=true)
    @Qualifier("employeeDAOService")
    private EmployeeDAOService employeeDAOService;
    
    
    @Autowired(required=true)
    @Qualifier("userDAOService")
    private UserDAOService userDAOService;
    

    //@RequestMapping(value="/app/main")
    @RequestMapping(value="/")
    public ModelAndView getTestJsp(){
        ModelAndView model = new ModelAndView("app/main");
        //employeeDAOService.addEmployee("Василий", "Пупкин", "Водитель", 2);
        //UserRole role = new UserRole();
        //role.setRole("USER");
        Set<UserRole> set = new HashSet<>();
        set.add(UserRole.USER);
        //userDAOService.addUser("aleksey", "123456", true, set);
        User user = userDAOService.findUserByLogin("aleksey");
        model.addObject("user_aleksey", user);
        //model.addObject("employees", EmployeeSupport.getEmployees());
        //throw new RuntimeException("Test");
        return model;
    }
    
    @RequestMapping(value="/dashboard")
    public String getDashboardPage(){
        return "app/content/dashboard";
    }
    
    @RequestMapping(value="/employers")
    public String getEmployersPage(){
        return "app/content/employers";
    }
    @RequestMapping(value="/reports")
    public String getReportsPage(){
        return "app/content/reports";
    }
    @RequestMapping(value="/calendar")
    public String getCalendarPage(){
        return "app/content/calendar";
    }
    
    @RequestMapping(value="/settings")
    public String getSettingsPage(){
        return "app/content/settings";
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
