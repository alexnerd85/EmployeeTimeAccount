/*
 *   Created on : 19.02.2018, 19:34:44
 *   Author     : Popov Aleksey
 *   Site       : alexnerd.com
 *   Email      : alexnerd85@gmail.com
 *   GitHub     : https://github.com/alexnerd85/EmployeeTimeAccount
 */

package com.alexnerd.employeetimeaccount.daoServices;

import com.alexnerd.employeetimeaccount.dao.UserDAO;
import com.alexnerd.employeetimeaccount.data.User;
import com.alexnerd.employeetimeaccount.data.User.UserRole;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDAOService")
@Transactional
public class UserDAOServiceImpl implements UserDAOService {

    @Autowired(required = true)
    @Qualifier("userDAO")
    private UserDAO userDAO;
    
    @Override
    @Transactional
    public User addUser(String login, String password, boolean enabled, Set<UserRole> userRoles) {
        return userDAO.addUser(new User(login, password, enabled, userRoles));
    }
    
    @Override
    @Transactional
    public User addUser(User user) {
        return userDAO.addUser(user);
    }

    @Override
    public User findUserByLogin(String login) {
        return userDAO.findUserByLogin(login);
    }

    @Override
    public boolean isLoginExist(String login) {
        return userDAO.isLoginExist(login);
    }
    
}
