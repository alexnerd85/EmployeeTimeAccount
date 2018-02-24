/*
 *   Created on : 21.39.2018, 21:39:19
 *   Author     : Popov Aleksey
 *   Site       : alexnerd.com
 *   Email      : alexnerd85@gmail.com
 *   GitHub     : https://github.com/alexnerd85/EmployeeTimeAccount
 */

package com.alexnerd.employeetimeaccount.controller;

import com.alexnerd.employeetimeaccount.daoServices.EmployeeDAOService;
import com.alexnerd.employeetimeaccount.daoServices.UserDAOService;
import com.alexnerd.employeetimeaccount.data.Employee;
import com.alexnerd.employeetimeaccount.data.User;
import org.hibernate.HibernateException;
import org.hibernate.JDBCException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserRESTController {
    
    @Autowired(required=true)
    @Qualifier("userDAOService")
    private UserDAOService userDAOService;
    
    @PostMapping(value="add")
    public boolean addUser(@RequestBody User user){
        userDAOService.addUser(user);
        //throw new RuntimeException();
        return true;
    }
    
    //updateUser
    //deleteUser
    //findUser
    
    @PostMapping(value="checklogin")
    public boolean checkLogin(@RequestParam("login") String login){
        return userDAOService.isLoginExist(login);
    }
    
    
    @ExceptionHandler(JDBCException.class)
    public ResponseEntity restException(JDBCException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage() + " " + ex.getSQLException().getMessage());
    }
    
}
