/*
 *   Created on : 21.01.2018, 21:18:44
 *   Author     : Popov Aleksey
 *   Site       : alexnerd.com
 *   Email      : alexnerd85@gmail.com
 *   GitHub     : https://github.com/alexnerd85/EQueue
 */

package com.alexnerd.employeetimeaccount.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext sc) throws ServletException {
        AnnotationConfigWebApplicationContext rootContext = 
                new AnnotationConfigWebApplicationContext();
        rootContext.register(WebConfig.class);
        
        sc.addListener(new ContextLoaderListener(rootContext));
        
        DispatcherServlet dispatcherServlet = new DispatcherServlet(rootContext);
        
        ServletRegistration.Dynamic registration = 
                sc.addServlet("dispatcherServlet", dispatcherServlet);
        
        registration.setLoadOnStartup(1);
        
        registration.addMapping("/");
    }
    
}
