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
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository("employeeDAO")
@Transactional
public class EmployeeDAOImpl implements EmployeeDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = false)
    @Override
    public Employee addEmployee(Employee employee) {
        entityManager.persist(employee);
        return employee;
    }
    
    @Transactional(readOnly = false)
    @Override
    public void deleteEmployee(Employee employee) {
        entityManager.remove(employee);
    }
    
    @Transactional(readOnly = false)
    @Override
    public boolean deleteEmployee(Long id) {
        int isSuccessful = entityManager.createQuery("DELETE FROM Employee e WHERE e.id=:id ")
                                .setParameter("id", id)
                                    .executeUpdate();
        if(isSuccessful == 0){
            return false;
        }        
        return true;
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
        query = query.trim();
        if(query.contains(" ")){
            String[] arr = query.split("\\s+");
            return (List<Employee>) entityManager
                .createQuery("FROM Employee e WHERE ((CONCAT(e.name) LIKE CONCAT('%',UPPER(:name),'%') AND CONCAT(e.sirname) LIKE CONCAT('%',UPPER(:sirname),'%')) OR ((CONCAT(e.sirname) LIKE CONCAT('%',UPPER(:name),'%') AND CONCAT(e.name) LIKE CONCAT('%',UPPER(:sirname),'%'))))").setParameter("name", arr[0]).setParameter("sirname", arr[1])
                    .getResultList();
            
        } else{
            return (List<Employee>) entityManager
                 .createQuery("FROM Employee e WHERE CONCAT(e.name, e.sirname, e.profession) LIKE CONCAT('%',UPPER(:query),'%')").setParameter("query", query)
                    .getResultList();
        }
        
    }
    
    @Transactional(readOnly = true)
    @Override
    public Employee getEmployeeById(Long id){
        return (Employee) entityManager.createQuery("FROM Employee e WHERE e.id=:id")
                .setParameter("id", id)
                    .getResultList()
                        .stream()
                            .findFirst()
                                .orElse(null);
    }
}
