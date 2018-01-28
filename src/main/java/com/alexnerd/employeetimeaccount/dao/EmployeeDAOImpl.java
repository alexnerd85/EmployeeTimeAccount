/*
 *   Created on : 28.01.2018, 23:09:24
 *   Author     : Popov Aleksey
 *   Site       : alexnerd.com
 *   Email      : alexnerd85@gmail.com
 *   GitHub     : https://github.com/alexnerd85/EmployeeTimeAccount
 */

package com.alexnerd.employeetimeaccount.dao;

import com.alexnerd.employeetimeaccount.data.Employee;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Aleksey
 */
@Repository("employeeDAO")
@Transactional
public class EmployeeDAOImpl implements EmployeeDAO {

    @PersistenceContext
    public EntityManager entityManager;

    @Transactional(readOnly = false)
    public Employee addEmployee(Employee employee) {
        entityManager.persist(employee);
        return employee;
    }
}
