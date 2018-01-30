/*
 *   Created on : 21.01.2018, 20:56:55
 *   Author     : Popov Aleksey
 *   Site       : alexnerd.com
 *   Email      : alexnerd85@gmail.com
 *   GitHub     : https://github.com/alexnerd85/EmployeeTimeAccount
 */

package com.alexnerd.employeetimeaccount.data;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
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
    //private List<Period> period;
    //пол
    @Enumerated(EnumType.ORDINAL)
    private Gender gender;

    public Employee() {
    }

    public Employee(Long id, String name, String patronymic, String sirname, 
            String profession, double wage_rate, LocalDate birthDate, 
            List<Period> period, Gender gender) {
        this.id = id;
        this.name = name;
        this.patronymic = patronymic;
        this.sirname = sirname;
        this.profession = profession;
        this.wage_rate = wage_rate;
        this.birthDate = birthDate;
        //this.period = period;
        this.gender = gender;
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

    /*
    public List<Period> getPeriod() {
        return period;
    }

    public void setPeriod(List<Period> period) {
        this.period = period;
    }
    */

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", patronymic=" + patronymic + ", sirname=" + sirname + ", profession=" + profession + ", wage_rate=" + wage_rate + ", birthDate=" + birthDate + ", period=" + ", gender=" + gender + '}';
    }
    
    public enum Gender{
        MAN, WOMAN;
    }
    
}
