/*
 *   Created on : 21.01.2018, 21:59:23
 *   Author     : Popov Aleksey
 *   Site       : alexnerd.com
 *   Email      : alexnerd85@gmail.com
 *   GitHub     : https://github.com/alexnerd85/EmployeeTimeAccount
 */

package com.alexnerd.employeetimeaccount.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages={"com.alexnerd.employeetimeaccount"})
@Import({ApplicationContext.class, SecurityConfig.class})
@PropertySource("classpath:DataSource.properties")
public class WebConfig extends WebMvcConfigurerAdapter{

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //registry.addViewController("/").setViewName("app/main");
        registry.addViewController("/login").setViewName("login");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        //registry.addViewController("/").setViewName("index");
        //registry.addViewController("/");
        //registry.addViewController("/app/main").setViewName("app/main");
        //registry.addViewController("/accessDenied").setViewName("accessDenied");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
    
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }
    
    @Bean
    public InternalResourceViewResolver internalResourceViewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/WEB-PAGES/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
}
