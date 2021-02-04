package view;

import java.util.Scanner;

public class MainView {
    // Defining Input Scanner
    static Scanner input = new Scanner(System.in);
    static AccountView action = new AccountView();
    static UserView users = new UserView();

    public static void main(String[] args) throws Exception {
        initialize();
    }

    public static void initializeAccount() {
        String condition;
        // Loops Unitll The condition is not 0
        do {
            System.out.println("#######################################################");
            System.out.println("\tWelcome To Teller Application!!");
            System.out.println("#######################################################");
            System.out.println("\t0) Exit");
            System.out.println("\t1) Add Account");
            System.out.println("\t2) Check Amount");
            System.out.println("\t3) Deposite Amount");
            System.out.println("\t4) Withdraw Amount");
            System.out.println("\t5) Transfure Amount A to B");
            System.out.println("\t6) Delete Account");
            System.out.println("\t7) All Accounts");
            System.out.println("#######################################################");
            System.out.println("\t8) Add User");
            System.out.println("\t9) Delete User");
            System.out.println("\t10) User list");
            System.out.println("#######################################################");
            System.out.println("\tEnter Appropriate Choice:");
            condition = input.next();
            System.out.println("#######################################################");
            switch (condition) {
                case "0":
                    printInLine("\tExiting: Account Operation!!");
                    break;
                case "1":
                    action.addAccountView();
                    break;
                case "2":
                    action.checkAmountView();
                    break;
                case "3":
                    action.depositAmountView();
                    break;
                case "4":
                    action.withdrawAmountView();
                    break;
                case "5":
                    action.transfurAmountView();
                    break;
                case "6":
                    action.deleteAccount();
                    break;
                case "7":
                    action.allAccountsView();
                    break;
                case "8":
                    users.addUserView();
                    break;
                case "9":
                    users.deleteUser();
                    break;
                case "10":
                    users.allUsersView();
                    break;
                default:
                    System.out.println("\tEnter Appropriate Choice!!");
                    System.out.println("#######################################################");
            }
        } while (!condition.equals("0"));
    }

    public static void initialize() {
        String condition;
        do {
            printInLine("\tWelcome To Teller Application!!");
            System.out.println("\t0) Exit");
            System.out.println("\t1) Login");
            System.out.println("#######################################################");
            System.out.println("\tEnter Appropriate Choice:");
            condition = input.next();
            System.out.println("#######################################################");
            switch (condition) {
                case "0":
                    printInLine("\tExiting: Catch you Later Aligator!!");
                    break;
                case "1":
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

        } while (!condition.equals("0"));
    }

    // Prints Message Within Lines
    public static void printInLine(String message) {
        if (message.length() != 0) {
            System.out.println("\n#######################################################");
            System.out.println(message);
            System.out.println("#######################################################");
        }
    }
}
