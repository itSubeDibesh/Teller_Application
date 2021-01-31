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
        System.out.println("Enter user name:");
        String userName = input.next();
        System.out.println("Enter password");
        String passWord = input.next();
        return users.login(userName, passWord);
    }

    // Adds User
    public void addUserView() {
        users.printInLine("\tLogin again to add user");
        if (loginView()) {
            System.out.println("Enter new user name:");
            String userName = input.next();
            System.out.println("Enter password:");
            String passWord = input.next();
            System.out.println("Retype password:");
            String repassWord = input.next();
            if (passWord.equals(repassWord)) {
                // Check if User Added
                if (users.addUser(userName, passWord))
                    users.printInLine("\tUser Added Successfully");
                else
                    users.printInLine("\tUser Already Exists");
            } else {
                users.printInLine("\tPassword Not Match, Please tryagain later!");
            }
        } else
            users.printInLine("\tInvalid login credentials, Access denied");
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
            users.printInLine("\tUser not found in storage.");
        }
    }

    // Deletes Selected User
    public void deleteUser() {
        users.printInLine("\tLogin again to delete user");
        if (loginView()) {
            System.out.println("Enter user name to delete:");
            String userName = input.next();
            if (users.deleteUser(userName))
                users.printInLine("\tUser deleted successfully.");
            else
                users.printInLine("\tUser not found in storage.");
        } else
            users.printInLine("\tInvalid login credentials, Access denied");
    }

}
