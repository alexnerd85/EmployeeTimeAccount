/*
 *   Created on : 28.01.2018, 23:09:24
 *   Author     : Popov Aleksey
 *   Site       : alexnerd.com
 *   Email      : alexnerd85@gmail.com
 *   GitHub     : https://github.com/alexnerd85/EmployeeTimeAccount
 */

package com.alexnerd.employeetimeaccount.dao;

import com.alexnerd.employeetimeaccount.data.Employee;
import java.nio.charset.Charset;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository("employeeDAO")
@Transactional
public class EmployeeDAOImpl implements EmployeeDAO {

    @PersistenceContext
    public EntityManager entityManager;

    @Transactional(readOnly = false)
    @Override
    public Employee addEmployee(Employee employee) {
        entityManager.persist(employee);
        return employee;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Employee> getAllEmployees() {
        return (List<Employee>) entityManager
                 .createQuery("FROM Employee")
                 .getResultList();
    }
    
    @Transactional(readOnly = true)
    @Override
    public List<Employee> search(String query) {
        return (List<Employee>) entityManager
                 .createQuery("FROM Employee e WHERE CONCAT(e.name, e.sirname, e.profession) LIKE CONCAT('%',UPPER(?),'%')").setParameter(0, query)
                 .getResultList();
        
    }
}
