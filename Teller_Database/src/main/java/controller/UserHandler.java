package controller;

import java.util.ArrayList;

import model.Users;

public class UserHandler {
    public ArrayList<Users> userList = new ArrayList<>();

    public boolean login(String userName, String passWord) {
        // Create Admin Account
        for (Users user : userList) {
            return user.getUserName().equalsIgnoreCase(userName) && user.getPassWord().equals(passWord);
        }
        return userName.equalsIgnoreCase("admin") && passWord.equalsIgnoreCase("admin");
    }

    // Add Users
    public boolean addUser(String userName, String passWord) {
        Users User = new Users(userName, passWord);
        if (findUser(userName) == null) {
            this.userList.add(User);
            return true;
        }
        return false;
    }

    // Find Users
    public Users findUser(String userName) {
        for (Users user : userList) {
            if (user.getUserName().equalsIgnoreCase(userName))
                return user;
        }
        return null;
    }

    // Delete User
    public boolean deleteUser(String userName) {
        // Store the search to User to avoide double search
        Users User = findUser(userName);
        if (User != null) {
            this.userList.remove(User);
            return true;
        }
        return false;
    }

    // Returns User List
    public ArrayList<Users> ListUsers() {
        return this.userList;
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
