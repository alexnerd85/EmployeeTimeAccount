/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alexnerd.employeetimeaccount.utils;

import com.alexnerd.employeetimeaccount.data.employee.Employee;
import com.alexnerd.employeetimeaccount.data.employee.Employee.Gender;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Aleksey
 */
public class EmployeeSupport {
    
    public static Set getEmployees(){
        Set<Employee> employyes = new HashSet();
        employyes.add(new Employee(new Long(1), "Алексей", "Владимирович", "Попов", 
                "Программист", 2000.0, LocalDate.of(1985, 8, 4), null, Gender.MAN));
        employyes.add(new Employee(new Long(2), "Василий", "Иванович", "Пупкин", 
                "Эксперт", 8000.0, LocalDate.of(1973, 10, 1), null, Gender.MAN));
        employyes.add(new Employee(new Long(3), "Марья", "Ивановна", "Хмельницкая", 
                "Секретарь", 1000.0, LocalDate.of(1989, 3, 2), null, Gender.WOMAN));
        
        return employyes;
    }
    
}
