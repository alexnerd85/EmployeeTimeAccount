/*
 *   Created on : 27.01.2018, 23:52:45
 *   Author     : Popov Aleksey
 *   Site       : alexnerd.com
 *   Email      : alexnerd85@gmail.com
 *   GitHub     : https://github.com/alexnerd85/EmployeeTimeAccount
 */

package com.alexnerd.employeetimeaccount.data;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import static javax.persistence.FetchType.EAGER;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
    
    //@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    //@OneToMany(fetch = FetchType.EAGER, mappedBy="user")
    //@OneToMany(fetch=EAGER, cascade=CascadeType.ALL)
    
    @ElementCollection(targetClass = com.alexnerd.employeetimeaccount.data.User.UserRole.class)
    @CollectionTable(name = "user_roles", joinColumns = {
        @JoinColumn(name = "login", referencedColumnName = "login")
    })
    @Enumerated(EnumType.STRING)
    private Set<UserRole> userRoles;

    public User() {
    }
    
    public User(String login, String password, boolean enabled, Set<UserRole> userRole){
        this.login = login;
        this.password = password;
        this.enabled = enabled;
        this.userRoles = userRole;
    }

    public User(String login, String password, String name, String patronymic, 
            String sirname, boolean enabled, Set<UserRole> userRole) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.patronymic = patronymic;
        this.sirname = sirname;
        this.enabled = enabled;
        this.userRoles = userRoles;
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

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRole) {
        this.userRoles = userRole;
    }
    
    public enum UserRole{
        USER, ADMIN
    }
}
