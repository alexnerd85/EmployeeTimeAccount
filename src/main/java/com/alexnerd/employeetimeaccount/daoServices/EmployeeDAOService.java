/*
 *   Created on : 28.01.2018, 23:09:24
 *   Author     : Popov Aleksey
 *   Site       : alexnerd.com
 *   Email      : alexnerd85@gmail.com
 *   GitHub     : https://github.com/alexnerd85/EmployeeTimeAccount
 */

package com.alexnerd.employeetimeaccount.daoServices;

import com.alexnerd.employeetimeaccount.data.Employee;

public interface EmployeeDAOService {
    public Employee addEmployee(String name, String sirname, String profession, double wage_rate);
}
