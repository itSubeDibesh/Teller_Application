package Users;

import java.util.Scanner;

import Account.Accounts;

public class Users {
    // Defining Input Scanner
    Scanner input = new Scanner(System.in);
    UserView users = new UserView();
    Accounts accounts = new Accounts();

    public void initialize() {
        int condition;
        do {
            System.out.println("#######################################################");
            System.out.println("Welcome To Teller Application!!");
            System.out.println("0) Exit");
            System.out.println("1) Login");
            System.out.println("#######################################################");
            System.out.println("Enter Appropriate Choice:");
            condition = input.nextInt();
            System.out.println("#######################################################");
            switch (condition) {
                case 0:
                    printInLine("Exiting: Catch you Later Aligator!!");
                    break;
                case 1:
                    if (users.loginView()) {
                        printInLine("Login Successfull!!");
                        accounts.initialize();
                    } else
                        printInLine("Invalid Username or Password!!");

                    break;
                default:
                    System.out.println("Enter Appropriate Choice!!");
                    System.out.println("#######################################################");
            }

        } while (condition != 0);
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
