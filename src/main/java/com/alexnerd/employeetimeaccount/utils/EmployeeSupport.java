/*
 *   Created on : 28.01.2018, 23:09:24
 *   Author     : Popov Aleksey
 *   Site       : alexnerd.com
 *   Email      : alexnerd85@gmail.com
 *   GitHub     : https://github.com/alexnerd85/EmployeeTimeAccount
 */

package com.alexnerd.employeetimeaccount.utils;

import com.alexnerd.employeetimeaccount.data.Employee;
import com.alexnerd.employeetimeaccount.data.Employee.Gender;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

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
