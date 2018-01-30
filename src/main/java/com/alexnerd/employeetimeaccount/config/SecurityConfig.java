/*
 *   Created on : 29.01.2018, 19:48:14
 *   Author     : Popov Aleksey
 *   Site       : alexnerd.com
 *   Email      : alexnerd85@gmail.com
 *   GitHub     : https://github.com/alexnerd85/EmployeeTimeAccount
 */
package com.alexnerd.employeetimeaccount.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");

        /*
        auth.inMemoryAuthentication()
                .withUser("admin").password("password").roles("ADMIN");
        */
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/app/**").hasRole("ADMIN")
                .antMatchers("/**").hasAnyRole("USER", "ADMIN")
                .anyRequest().authenticated()
                .and()
                //.httpBasic()
                .formLogin()
                .and()
                .exceptionHandling().accessDeniedPage("/accessDenied");
        */
        /*
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/app/**").hasRole("USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .exceptionHandling().accessDeniedPage("/accessDenied");
        */
        
        http
            .authorizeRequests()
                .antMatchers("/resources/**").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                //.loginPage("/login")
                .permitAll()
                .and()
            .logout()                                    
                .permitAll()
            .and()
                .exceptionHandling().accessDeniedPage("/accessDenied");
    }

    /*
    @Override
    public void configure(WebSecurity web) throws Exception {

        web.ignoring()
                .antMatchers("/resources/**");

    }
*/

}
