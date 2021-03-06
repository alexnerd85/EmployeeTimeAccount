/*
 *   Created on : 21.01.2018, 21:18:44
 *   Author     : Popov Aleksey
 *   Site       : alexnerd.com
 *   Email      : alexnerd85@gmail.com
 *   GitHub     : https://github.com/alexnerd85/EmployeeTimeAccount
 */

package com.alexnerd.employeetimeaccount.config;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext sc) throws ServletException {
        AnnotationConfigWebApplicationContext rootContext = 
                new AnnotationConfigWebApplicationContext();
        rootContext.register(WebConfig.class);
        //rootContext.register(ApplicationContext.class);
        
        rootContext.setServletContext(sc);
        
        //sc.addListener(new ContextLoaderListener(rootContext));
        DelegatingFilterProxy filter = new DelegatingFilterProxy("springSecurityFilterChain");
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceEncoding(true);
        
        DispatcherServlet dispatcherServlet = new DispatcherServlet(rootContext);
        
        ServletRegistration.Dynamic registration = 
                sc.addServlet("dispatcherServlet", dispatcherServlet);
        sc.addFilter("springSecurityFilterChain", filter).
                addMappingForUrlPatterns(null, false, "/*");
        sc.addFilter("encodingFilter", encodingFilter).addMappingForUrlPatterns(null, false, "/*");
        
        registration.setLoadOnStartup(1);
        
        registration.addMapping("/");
    }
    
    /*
    
       webContext.register(DatabaseConfig.class);
    
    */
    
}
