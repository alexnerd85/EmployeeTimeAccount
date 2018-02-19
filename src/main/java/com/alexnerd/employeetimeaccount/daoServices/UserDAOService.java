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


public interface UserDAOService {
    public User addUser(String login, String password, boolean enabled, UserRole userRole);
}
