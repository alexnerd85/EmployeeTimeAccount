/*
 *   Created on : 28.01.2018, 23:09:24
 *   Author     : Popov Aleksey
 *   Site       : alexnerd.com
 *   Email      : alexnerd85@gmail.com
 *   GitHub     : https://github.com/alexnerd85/EmployeeTimeAccount
 */

package com.alexnerd.employeetimeaccount.services;

import com.alexnerd.employeetimeaccount.dao.EmployeeDAO;
import com.alexnerd.employeetimeaccount.data.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired(required = true)
    @Qualifier("employeeDAO")
    private EmployeeDAO employeeDAO;

    @Transactional
    public Employee addEmployee(String customerName) {
        System.out.println("Cusomer Service create invoked:" + customerName);
        Employee employee = new Employee();
        employee.setName(customerName);
        employee = employeeDAO.addEmployee(employee);
        return employee;
    }

}
