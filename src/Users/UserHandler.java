package Users;

import java.util.ArrayList;

public class UserHandler {
    public ArrayList<UsersClass> userList = new ArrayList<>();

    public boolean login(String userName, String passWord) {
        // Create Admin Account
        for (UsersClass user : userList) {
            return user.getUserName().equalsIgnoreCase(userName) && user.getPassWord().equals(passWord);
        }
        return userName.equalsIgnoreCase("admin") && passWord.equalsIgnoreCase("admin");
    }

    // Add Users
    public boolean addUser(String userName, String passWord) {
        UsersClass User = new UsersClass(userName, passWord);
        if (findUser(userName) == null) {
            this.userList.add(User);
            return true;
        }
        return false;
    }

    // Find Users
    public UsersClass findUser(String userName) {
        for (UsersClass user : userList) {
            if (user.getUserName().equalsIgnoreCase(userName))
                return user;
        }
        return null;
    }

    // Delete User
    public boolean deleteUser(String userName) {
        // Store the search to User to avoide double search
        UsersClass User = findUser(userName);
        if (User != null) {
            this.userList.remove(User);
            return true;
        }
        return false;
    }

    // Returns User List
    public ArrayList<UsersClass> ListUsers() {
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
