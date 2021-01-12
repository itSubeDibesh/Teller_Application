package Account;

import java.util.Scanner;

public class Accounts {
    // Initialize Accounts to haldel account operations
    public void initialize() {
        AccountView action = new AccountView();
        // Defining Input Scanner
        Scanner input = new Scanner(System.in);
        int condition;
        // Loops Unitll The condition is not 0
        do {
            System.out.println("#######################################################");
            System.out.println("Welcome To Teller Application!!");
            System.out.println("0) Exit");
            System.out.println("1) Add Account");
            System.out.println("2) Check Amount");
            System.out.println("3) Deposite Amount");
            System.out.println("4) Withdraw Amount");
            System.out.println("5) Transfure Amount A to B");
            System.out.println("6) Delete Account");
            System.out.println("7) All Accounts");
            System.out.println("#######################################################");
            System.out.println("Enter Appropriate Choice:");
            condition = input.nextInt();
            System.out.println("#######################################################");
            switch (condition) {
                case 0:
                    System.out.println("\n#######################################################");
                    System.out.println("Exiting: Catch you Later Aligator!!");
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
                default:
                    System.out.println("Enter Appropriate Choice!!");
                    System.out.println("#######################################################");
            }
        } while (condition != 0);
    }
}
