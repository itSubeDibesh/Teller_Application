package Views;

import java.util.Scanner;

import Account.AccountView;
import Users.UserView;

public class ConsoleView {
    // Defining Input Scanner
    Scanner input = new Scanner(System.in);
    AccountView action = new AccountView();
    UserView users = new UserView();

    public void initializeAccount() {
        int condition;
        // Loops Unitll The condition is not 0
        do {
            System.out.println("#######################################################");
            System.out.println("\tWelcome To Teller Application!!");
            System.out.println("#######################################################");
            System.out.println("0) Exit");
            System.out.println("1) Add Account");
            System.out.println("2) Check Amount");
            System.out.println("3) Deposite Amount");
            System.out.println("4) Withdraw Amount");
            System.out.println("5) Transfure Amount A to B");
            System.out.println("6) Delete Account");
            System.out.println("7) All Accounts");
            System.out.println("#######################################################");
            System.out.println("8) Add User");
            System.out.println("9) Delete User");
            System.out.println("10) User list");
            System.out.println("#######################################################");
            System.out.println("\tEnter Appropriate Choice:");
            condition = input.nextInt();
            System.out.println("#######################################################");
            switch (condition) {
                case 0:
                    System.out.println("\n#######################################################");
                    System.out.println("\tExiting: Account Operation!!");
                    System.out.println("#######################################################\n");
                    break;
                case 1:
                    action.addAccountView();
                    break;
                case 2:
                    action.checkAmountView();
                    break;
                case 3:
                    action.depositAmountView();
                    break;
                case 4:
                    action.withdrawAmountView();
                    break;
                case 5:
                    action.transfurAmountView();
                    break;
                case 6:
                    action.deleteAccount();
                    break;
                case 7:
                    action.allAccountsView();
                    break;
                case 8:
                    users.addUserView();
                    break;
                case 9:
                    users.deleteUser();
                    break;
                case 10:
                    users.allUsersView();
                    break;
                default:
                    System.out.println("\tEnter Appropriate Choice!!");
                    System.out.println("#######################################################");
            }
        } while (condition != 0);
    }

    public void initialize() {
        int condition;
        do {
            System.out.println("#######################################################");
            System.out.println("\tWelcome To Teller Application!!");
            System.out.println("#######################################################");
            System.out.println("0) Exit");
            System.out.println("1) Login");
            System.out.println("#######################################################");
            System.out.println("\tEnter Appropriate Choice:");
            condition = input.nextInt();
            System.out.println("#######################################################");
            switch (condition) {
                case 0:
                    printInLine("\tExiting: Catch you Later Aligator!!");
                    break;
                case 1:
                    if (users.loginView()) {
                        printInLine("\tLogin Successfull!!");
                        initializeAccount();
                    } else
                        printInLine("\tInvalid Username or Password!!");

                    break;
                default:
                    System.out.println("\tEnter Appropriate Choice!!");
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
