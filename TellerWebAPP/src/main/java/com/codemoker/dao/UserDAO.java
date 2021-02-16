/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemoker.dao;

import com.codemoker.domain.Users;
import java.util.ArrayList;

/**
 *
 * @author kingr
 */
public interface UserDAO {

    public boolean login(String userName, String passWord);

    public boolean addUser(String userName, String passWord);

    public Users findUser(String userName);

    public boolean deleteUser(String userName);

    public ArrayList<Users> ListUsers();
}
