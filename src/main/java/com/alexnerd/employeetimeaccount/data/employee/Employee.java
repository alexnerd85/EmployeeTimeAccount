/*
 *   Created on : 21.01.2018, 20:56:55
 *   Author     : Popov Aleksey
 *   Site       : alexnerd.com
 *   Email      : alexnerd85@gmail.com
 *   GitHub     : https://github.com/alexnerd85/EQueue
 */

package com.alexnerd.employeetimeaccount.data.employee;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;


public class Employee {
    private Long id;
    //имя
    private String name;
    //отчество
    private String patronymic;
    //фамилия
    private String sirname;
    //специальность
    private String profession;
    //количество занимаемых ставок
    private double wage_rate;
    //дата рождения
    private LocalDate birthDate;
    //периоды отсутствия
    private List<Period> period;
    //пол
    private Gender gender;

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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public double getWage_rate() {
        return wage_rate;
    }

    public void setWage_rate(double wage_rate) {
        this.wage_rate = wage_rate;
    }

    public List<Period> getPeriod() {
        return period;
    }

    public void setPeriod(List<Period> period) {
        this.period = period;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
    
    public enum Gender{
        MAN, WOMAN;
    }
    
    
}
