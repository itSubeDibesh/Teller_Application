/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemoker.dao;

import static com.codemoker.dao.DatabaseVariable.db;
import com.codemoker.domain.Users;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author kingr
 */
public class UserDAOImplementation implements UserDAO {

    @Override
    public boolean login(String userName, String passWord) {
        //To change body of generated methods, choose Tools | Templates.
        Users user = findUser(userName);
        if (user != null) {
            return user.getUserName().equalsIgnoreCase(userName) && user.getPassWord().equals(passWord);
        }
        return false;
    }

    @Override
    public boolean addUser(String userName, String passWord) {
        //To change body of generated methods, choose Tools | Templates.
        if (findUser(userName) == null) {
            String sql = "INSERT INTO `tellerdb`.`user` (`userName`,`passWord`) VALUES ('" + userName + "','" + passWord + "');";
            return db.iud(sql);
        }
        return false;
    }

    @Override
    public Users findUser(String userName) {
        //To change body of generated methods, choose Tools | Templates.
        String sql = "SELECT `user`.`userName`,`user`.`passWord` FROM `tellerdb`.`user` WHERE `user`.`userName` = '" + userName + "';";
        ResultSet rs = db.select(sql);
        try {
            if (rs != null) {
                while (rs.next()) {
                    Users user = new Users(rs.getString(1), rs.getString(2));
                    return user;
                }
            } else {
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
        return null;
    }

    @Override
    public boolean deleteUser(String userName) {
        //To change body of generated methods, choose Tools | Templates.
        Users User = findUser(userName);
        if (User != null) {
            String sql = "DELETE FROM `tellerdb`.`user` WHERE `user`.`userName` = '" + userName + "';";
            return db.iud(sql);
        }
        return false;
    }

    @Override
    public ArrayList<Users> ListUsers() {
        //To change body of generated methods, choose Tools | Templates.
        String sql = "SELECT `user`.`userName`,`user`.`passWord` FROM `tellerdb`.`user`;";
        ResultSet rs = db.select(sql);
        ArrayList<Users> list = new ArrayList<>();
        list.clear();
        try {
            while (rs.next()) {
                Users users = new Users(rs.getString(1), rs.getString(2));
                list.add(users);
            }
            return list;
        } catch (SQLException ex) {
            return null;
        }
    }

}
