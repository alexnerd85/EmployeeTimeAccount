/*
 *   Created on : 27.01.2018, 23:52:45
 *   Author     : Popov Aleksey
 *   Site       : alexnerd.com
 *   Email      : alexnerd85@gmail.com
 *   GitHub     : https://github.com/alexnerd85/EmployeeTimeAccount
 */

package com.alexnerd.employeetimeaccount.data;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", unique=true, nullable=false)
    private Long id;
    
    //логин
    @Column(name="login", unique=true, nullable=false)
    private String login;
    
    //пароль
    @Column(name="password", nullable=false)
    private String password;
    
    //имя
    @Column(name="name")
    private String name;
    
    //отчество
    @Column(name="patronymic")
    private String patronymic;
    
    //фамилия
    @Column(name="sirname")
    private String sirname;
    
    @Column(name="enabled", nullable=false)
    private boolean enabled;
    
    @Enumerated(EnumType.STRING)
    @Column(name="userRole", nullable=false)
    private UserRole userRole;

    public User() {
    }
    
    public User(String login, String password, boolean enabled, UserRole userRole){
        this.login = login;
        this.password = password;
        this.enabled = enabled;
        this.userRole = userRole;
    }

    public User(String login, String password, String name, String patronymic, 
            String sirname, boolean enabled, UserRole userRole) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.patronymic = patronymic;
        this.sirname = sirname;
        this.enabled = enabled;
        this.userRole = userRole;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getSirname() {
        return sirname;
    }

    public void setSirname(String sirname) {
        this.sirname = sirname;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public UserRole getUserRoles() {
        return userRole;
    }

    public void setUserRoles(UserRole userRole) {
        this.userRole = userRole;
    }
    
    public enum UserRole {
        USER, ADMIN    
    }
    
}
