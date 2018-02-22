/*
 *   Created on : 19.02.2018, 19:23:59
 *   Author     : Popov Aleksey
 *   Site       : alexnerd.com
 *   Email      : alexnerd85@gmail.com
 *   GitHub     : https://github.com/alexnerd85/EmployeeTimeAccount
 */

package com.alexnerd.employeetimeaccount.daoServices;

import com.alexnerd.employeetimeaccount.data.User;
import com.alexnerd.employeetimeaccount.data.User.UserRole;
import java.util.Set;


public interface UserDAOService {
    public User addUser(String login, String password, boolean enabled, Set<UserRole> userRoles);
    public User addUser(User user);
    public User findUserByLogin(String login);
    public boolean isLoginExist(String login);
}
