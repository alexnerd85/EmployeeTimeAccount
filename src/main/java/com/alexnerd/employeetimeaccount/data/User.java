/*
 *   Created on : 27.01.2018, 23:52:45
 *   Author     : Popov Aleksey
 *   Site       : alexnerd.com
 *   Email      : alexnerd85@gmail.com
 *   GitHub     : https://github.com/alexnerd85/EmployeeTimeAccount
 */

package com.alexnerd.employeetimeaccount.data;

public class User {
    private Long id;
    //логин
    private String login;
    //пароль
    private String password;
    //имя
    private String name;
    //отчество
    private String patronymic;
    //фамилия
    private String sirname;
    //специальность
    private String profession;

    public User() {
    }

    public User(String login, String password, String name, String patronymic, 
            String sirname, String profession) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.patronymic = patronymic;
        this.sirname = sirname;
        this.profession = profession;
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

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
    
}
