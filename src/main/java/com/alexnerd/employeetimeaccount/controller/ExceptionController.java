/*
 *   Created on : 18.02.2018, 11:39:08
 *   Author     : Popov Aleksey
 *   Site       : alexnerd.com
 *   Email      : alexnerd85@gmail.com
 *   GitHub     : https://github.com/alexnerd85/EmployeeTimeAccount
 */

package com.alexnerd.employeetimeaccount.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionController {
    
    @ExceptionHandler(Exception.class)
    public ModelAndView customExceptionHandler(Exception ex){
        ModelAndView model = new ModelAndView();
        model.addObject("errMsg", ex.getMessage());
        model.setViewName("error");
        return model;
    }
}
    