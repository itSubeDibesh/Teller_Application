package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Users;

public class UserHandler {

    public DBConnection db = new DBConnection();

    public boolean login(String userName, String passWord) {
        Users user = findUser(userName);
        if (user != null) {
            return user.getUserName().equalsIgnoreCase(userName) && user.getPassWord().equals(passWord);
        }
        return false;
    }

    // Add Users
    public boolean addUser(String userName, String passWord) {
        if (findUser(userName) == null) {
            String sql = "INSERT INTO `tellerdb`.`user` (`userName`,`passWord`) VALUES ('" + userName + "','" + passWord + "');";
            return db.iud(sql);
        }
        return false;
    }

    // Find Users
    public Users findUser(String userName) {
        String sql = "SELECT `user`.`userName`,`user`.`passWord` FROM `tellerdb`.`user` WHERE `user`.`userName` = '" + userName + "';";
        ResultSet rs = db.select(sql);
        try {
            if (rs != null) {
                while (rs.next()) {
                    Users user = new Users(rs.getString(1), rs.getString(2));
                    return user;
                }
            }
            else return null;
        } catch (SQLException ex) {
            return null;
        }
        return null;
    }

    // Delete User
    public boolean deleteUser(String userName) {
        // Store the search to User to avoide double search
        Users User = findUser(userName);
        if (User != null) {
            String sql = "DELETE FROM `tellerdb`.`user` WHERE `user`.`userName` = '" + userName + "';";
            return db.iud(sql);
        }
        return false;
    }

    // Returns User List
    public ArrayList<Users> ListUsers() {
        String sql = "SELECT `user`.`userName`,`user`.`passWord` FROM `tellerdb`.`user`;";
        ResultSet rs = db.select(sql);
        ArrayList<Users> list = new ArrayList<>();
        try {
            while (rs.next()) {
                Users users = new Users(rs.getString(1), rs.getString(2));
                list.add(users);
            }
            System.out.println(list);
            return list;
        } catch (SQLException ex) {
            return null;
        }
    }

    // Prints Message Within Lines
    public void printInLine(String message) {
        if (message.length() != 0) {
            System.out.println("\n#######################################################");
            System.out.println(message);
            System.out.println("#######################################################\n");
        }
    }
}
