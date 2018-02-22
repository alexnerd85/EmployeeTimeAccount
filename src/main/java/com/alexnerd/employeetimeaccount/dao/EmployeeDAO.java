/*
 *   Created on : 28.01.2018, 23:09:24
 *   Author     : Popov Aleksey
 *   Site       : alexnerd.com
 *   Email      : alexnerd85@gmail.com
 *   GitHub     : https://github.com/alexnerd85/EmployeeTimeAccount
 */

package com.alexnerd.employeetimeaccount.dao;

import com.alexnerd.employeetimeaccount.data.Employee;
import java.util.List;

public interface EmployeeDAO {
    public Employee addEmployee(Employee employee);
    public List<Employee> getAllEmployees();
    public List<Employee> search(String query);
}
