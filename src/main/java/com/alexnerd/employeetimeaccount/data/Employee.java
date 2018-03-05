/*
 *   Created on : 21.01.2018, 20:56:55
 *   Author     : Popov Aleksey
 *   Site       : alexnerd.com
 *   Email      : alexnerd85@gmail.com
 *   GitHub     : https://github.com/alexnerd85/EmployeeTimeAccount
 */

package com.alexnerd.employeetimeaccount.data;

import com.alexnerd.employeetimeaccount.utils.LocalDateDeserializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employees")
@JsonInclude(Include.NON_NULL)
public class Employee implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", unique=true, nullable=false)
    private Long id;
    
    //имя
    @Column(name="name", nullable=false)
    private String name;
    
    //отчество
    @Column(name="patronymic")
    private String patronymic;
    
    //фамилия
    @Column(name="sirname", nullable=false)
    private String sirname;
    
    //специальность
    @Column(name="profession", nullable=false)
    private String profession;
    
    //количество занимаемых ставок
    @Column(name="wage_rate", nullable=false)
    private double wage_rate;
    
    //дата рождения
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)  
    @Column(name="birthDate")
    private LocalDate birthDate;
    
    //периоды отсутствия
    //private List<Period> periods;
    
    //пол
    @Enumerated(EnumType.ORDINAL)
    @Column(name="gender", nullable=false)
    private Gender gender;

    public Employee() {
    
    }
    
    public Employee(String name, String sirname, String profession, double wage_rate){
        this.name = name;
        this.sirname = sirname;
        this.profession = profession;
        this.wage_rate = wage_rate;
    }

    public Employee(String name, String patronymic, String sirname, 
            String profession, double wage_rate, LocalDate birthDate, 
            List<Period> periods, Gender gender) {
        this.name = name;
        this.patronymic = patronymic;
        this.sirname = sirname;
        this.profession = profession;
        this.wage_rate = wage_rate;
        this.birthDate = birthDate;
        //this.periods = periods;
        this.gender = gender;
    }
    
    public Employee(Long id, String name, String patronymic, String sirname, 
            String profession, double wage_rate, LocalDate birthDate, 
            List<Period> periods, Gender gender) {
        this.id = id;
        this.name = name;
        this.patronymic = patronymic;
        this.sirname = sirname;
        this.profession = profession;
        this.wage_rate = wage_rate;
        this.birthDate = birthDate;
        //this.periods = periods;
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
    @ElementCollection
    @CollectionTable(name="periods", joinColumns=@JoinColumn(name="id"))
    @Column(name="periods")
    public List<Period> getPeriods() {
        return periods;
    }

    public void setPeriod(List<Period> periods) {
        this.periods = periods;
    }
    
    public boolean addPeriod(Period period){
        synchronized(this.periods){
            return periods.add(period);
        }
    }
    
    public boolean removePeriod(Period period){
        synchronized(this.periods){
            return periods.remove(period);
        }
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
