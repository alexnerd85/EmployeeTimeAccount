/*
 *   Created on : 19.02.2018, 19:14:42
 *   Author     : Popov Aleksey
 *   Site       : alexnerd.com
 *   Email      : alexnerd85@gmail.com
 *   GitHub     : https://github.com/alexnerd85/EmployeeTimeAccount
 */
package com.alexnerd.employeetimeaccount.dao;

import com.alexnerd.employeetimeaccount.data.User;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    public EntityManager entityManager;

    @Transactional(readOnly = false)
    @Override
    public User addUser(User user) {
        entityManager.persist(user);
        return user;
    }

    @Transactional(readOnly = true)
    @Override
    public User findUserByLogin(String login) {
         return (User) entityManager
                 .createQuery("FROM User u WHERE u.login = :login")
                 .setParameter("login", login)
                 .getResultList()
                 .stream()
                 .findFirst()
                 .orElse(null);
                                            
    }
    
    @Transactional(readOnly = true)
    @Override
    public boolean isLoginExist(String login) {
        Long i = (Long) entityManager.createQuery("SELECT COUNT (u) FROM User u WHERE u.login = :login")
                                        .setParameter("login", login).getSingleResult();
        
        return ( !( i.equals( 0L ) ) );
    }

}
