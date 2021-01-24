package Users;

import java.util.ArrayList;
import java.util.Scanner;

public class UserView {
    // Instiantiating User Handler to invoke its methords
    public UserHandler users = new UserHandler();

    // Defining Input Scanner
    Scanner input = new Scanner(System.in);

    // Returns Login true or false
    public boolean loginView() {
        System.out.println("Enter User Name:");
        String userName = input.next();
        System.out.println("Enter Password");
        String passWord = input.next();
        return users.login(userName, passWord);
    }

    // Adds User
    public void addUserView() {
        System.out.println("Enter New User Name:");
        String userName = input.next();
        System.out.println("Enter Password:");
        String passWord = input.next();
        System.out.println("Retype Password:");
        String repassWord = input.next();
        if (passWord.equals(repassWord)) {
            // Check if User Added
            if (users.addUser(userName, passWord))
                users.printInLine("\tUser Added Successfully");
            else
                users.printInLine("\tUser Already Exists");
        } else {
            users.printInLine("\tPassword Not Match, Please tryagain later1");
        }
    }

    // Display All User
    public void allUsersView() {
        ArrayList<UsersClass> userList = users.userList;
        int size = userList.size();
        if (size != 0) {
            // Users Exists
            users.printInLine(size + " " + (size == 1 ? "users" : "userss") + " found and listed below.");
            int count = 1;
            for (UsersClass user : userList) {
                System.out.println(
                        count++ + "-> User Name: " + user.getUserName() + " |  Password: " + user.getPassWord());
            }
            System.out.println("#######################################################\n");
        } else {
            // User Dont Exist
            users.printInLine("User not found in storage.");
        }
    }

    // Deletes Selected User
    public void deleteUser() {
        System.out.println("Enter User Name:");
        String userName = input.next();
        if (users.deleteUser(userName))
            users.printInLine("\tUser Deleted Successfully.");
        else
            users.printInLine("\tUser not found in storage.");
    }

}
