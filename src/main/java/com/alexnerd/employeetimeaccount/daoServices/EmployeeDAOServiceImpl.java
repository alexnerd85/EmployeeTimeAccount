/*
 *   Created on : 28.01.2018, 23:09:24
 *   Author     : Popov Aleksey
 *   Site       : alexnerd.com
 *   Email      : alexnerd85@gmail.com
 *   GitHub     : https://github.com/alexnerd85/EmployeeTimeAccount
 */

package com.alexnerd.employeetimeaccount.daoServices;

import com.alexnerd.employeetimeaccount.dao.EmployeeDAO;
import com.alexnerd.employeetimeaccount.data.Employee;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("employeeDAOService")
@Transactional
public class EmployeeDAOServiceImpl implements EmployeeDAOService {

    @Autowired(required = true)
    @Qualifier("employeeDAO")
    private EmployeeDAO employeeDAO;

    @Override
    @Transactional
    public Employee addEmployee(String name, String sirname, String profession, double wage_rate) {
        return employeeDAO.addEmployee(new Employee(name, sirname, profession, wage_rate));        
    }
    
    @Override
    @Transactional
    public Employee addEmployee(Employee employee) {
        return employeeDAO.addEmployee(employee);        
    }

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    @Transactional
    public List<Employee> search(String query) {
        return employeeDAO.search(query);
    }
    
    @Override
    @Transactional
    public Employee getEmployeeById(Long id) {
        return employeeDAO.getEmployeeById(id);
    }
}
