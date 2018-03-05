/*
 *   Created on : 28.01.2018, 23:09:24
 *   Author     : Popov Aleksey
 *   Site       : alexnerd.com
 *   Email      : alexnerd85@gmail.com
 *   GitHub     : https://github.com/alexnerd85/EmployeeTimeAccount
 */

package com.alexnerd.employeetimeaccount.daoServices;

import com.alexnerd.employeetimeaccount.data.Employee;
import java.util.List;

public interface EmployeeDAOService {
    public Employee addEmployee(String name, String sirname, String profession, double wage_rate);
    public Employee addEmployee(Employee employee);
    public void deleteEmployee(Employee employee);
    public boolean deleteEmployee(Long id);
    public List<Employee> getAllEmployees();
    public List<Employee> search(String query);
    public Employee getEmployeeById(Long id);
}
