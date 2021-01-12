package Account;

import java.util.ArrayList;
import java.util.Scanner;

public class AccountView {
    // Instiantiating Account Handler to invoke its methords
    public AccountHandeler storage = new AccountHandeler();

    // Adds Account
    public void addAccountView() {
        // Defining Input Scanner
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Account Number:");
        int accountNumber = input.nextInt();
        System.out.println("Enter Account Name:");
        String accountName = input.next();
        System.out.println("Enter Opeaning Balance:");
        float accountBalance = input.nextFloat();
        // Check if Account Added
        if (storage.addAccount(accountNumber, accountName, accountBalance)) {
            System.out.println("#######################################################");
            System.out.println("Account Added Successfully");
            System.out.println("#######################################################\n");
        } else {
            System.out.println("#######################################################");
            System.out.println("Account Already Exists");
            System.out.println("#######################################################\n");
        }
    }

    // Checks Amount
    public void checkAmountView() {
        // Defining Input Scanner
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Account Number:");
        int accountNumber = input.nextInt();
        AcccountClass account = storage.findAccount(accountNumber);
        float amount = storage.checkAmount(accountNumber);
        if (account != null) {
            if (amount != 0) {
                System.out.println("#######################################################");
                System.out.println(
                        "Account Number " + account.getAccountNumber() + " has balance of Rs: " + amount + "/-");
                System.out.println("#######################################################\n");
            } else {
                System.out.println("#######################################################");
                System.out.println("Account Number " + account.getAccountNumber() + " has no baance left.");
                System.out.println("#######################################################\n");
            }
        } else {
            System.out.println("#######################################################");
            System.out.println("Enter Valid Account Number.");
            System.out.println("#######################################################\n");
        }
    }

    // Deposits Amount
    public void depositAmountView() {
        // Defining Input Scanner
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Account Number:");
        int accountNumber = input.nextInt();
        System.out.println("Enter Deposite Balance:");
        float amount = input.nextFloat();
        AcccountClass account = storage.findAccount(accountNumber);
        float depositAmount = storage.depositeAmount(accountNumber, amount);
        if (account != null) {
            if (depositAmount != 0) {
                System.out.println("#######################################################");
                System.out.println("New Deposite Request of Rs: " + amount + "/- on Account number "
                        + account.getAccountNumber() + ".");
                System.out.println("Account Number " + account.getAccountNumber() + " has new balance of Rs: "
                        + depositAmount + "/-");
                System.out.println("#######################################################\n");
            } else {
                System.out.println("#######################################################");
                System.out.println("Problem With Server Please Try again later.");
                System.out.println("#######################################################\n");
            }
        } else {
            System.out.println("#######################################################");
            System.out.println("Enter Valid Account Number.");
            System.out.println("#######################################################\n");
        }
    }

    // Withdraw Amount
    public void withdrawAmountView() {
        // Defining Input Scanner
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Account Number:");
        int accountNumber = input.nextInt();
        System.out.println("Enter Withdraw Balance:");
        float amount = input.nextFloat();
        AcccountClass account = storage.findAccount(accountNumber);
        float withdraw = storage.withdrawAmount(accountNumber, amount);
        if (account != null) {
            // Accounts Exists
            if (withdraw > 0) {
                // Withdraw
                System.out.println("#######################################################");
                System.out.println("New Withdraw Request of Rs: " + amount + "/-on Account number "
                        + account.getAccountNumber() + ".");
                System.out.println(
                        "Account Number " + account.getAccountNumber() + " has new balance of Rs: " + withdraw + "/-");
                System.out.println("#######################################################\n");
            } else {
                // Balance insufficent
                System.out.println("#######################################################");
                System.out.println("Account Number " + account.getAccountNumber() + " has insufficent balance(Rs "
                        + account.getAccountBalance() + "/-) to withdraw(Rs " + amount + "/-).");
                System.out.println("#######################################################\n");
            }
        } else {
            // Accound Dont Exists
            System.out.println("#######################################################");
            System.out.println("Enter Valid Account Number.");
            System.out.println("#######################################################\n");
        }
    }

    // Transfure Amount
    public void transfurAmountView() {
        // Defining Input Scanner
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Sender Account Number:");
        int senderAccount = input.nextInt();
        System.out.println("Enter Receiver Account Number:");
        int receiverAccount = input.nextInt();
        System.out.println("Enter Transfure Balance:");
        float amount = input.nextFloat();
        AcccountClass account_A = storage.findAccount(senderAccount);
        AcccountClass account_B = storage.findAccount(receiverAccount);
        int transfur = storage.transfureAmountA_to_B(senderAccount, receiverAccount, amount);
        if (transfur == 1) {
            System.out.println("#######################################################");
            System.out.println("New Withdraw Request of Rs: " + amount + "/- on Account number "
                    + account_A.getAccountNumber() + ".");
            System.out.println("New Deposite Request of Rs: " + amount + "/- on Account number "
                    + account_B.getAccountNumber() + ".");
            System.out.println("Sender Account Number " + account_A.getAccountNumber() + " has new balance of Rs: "
                    + account_A.getAccountBalance() + "/-");
            System.out.println("Receiver Account Number " + account_B.getAccountNumber() + " has new balance of Rs: "
                    + account_B.getAccountBalance() + "/-");
            System.out.println("#######################################################\n");
        } else if (transfur == 0) {
            // Balance insufficent
            System.out.println("#######################################################");
            System.out.println("Sender Account Number " + account_A.getAccountNumber() + " has insufficent balance(Rs "
                    + account_A.getAccountBalance() + "/-) to withdraw(Rs " + amount + "/-).");
            System.out.println("#######################################################\n");
        } else {
            // Accound Dont Exists
            System.out.println("#######################################################");
            System.out.println("Enter Valid Account Number.");
            System.out.println("#######################################################\n");
        }
    }

    // Display All Account
    public void allAccountsView() {
        ArrayList<AcccountClass> accountList = storage.accountsList;
        int size = accountList.size();
        if (size != 0) {
            // Accounts Exists
            System.out.println("\n#######################################################");
            System.out.println(size + " Accounts Exists and are listed below.");
            System.out.println("#######################################################");
            int count = 1;
            for (AcccountClass account : accountList) {
                System.out.println(count++ + ") Account Number: " + account.getAccountNumber() + " Account Name: "
                        + account.getAccountName() + " Account Balance: " + account.getAccountBalance() + "/-");
            }
            System.out.println("#######################################################\n");
        } else {
            // Accounts Dont Exist
            System.out.println("\n#######################################################");
            System.out.println("Accounts not found in storage.");
            System.out.println("#######################################################\n");
        }
    }

    public void deleteAccount() {
        // Defining Input Scanner
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Account Number:");
        int accountNumber = input.nextInt();
        if (storage.deleteAccount(accountNumber)) {
            System.out.println("\n#######################################################");
            System.out.println("Accounts Deleted Successfully.");
            System.out.println("#######################################################\n");
        } else {
            System.out.println("\n#######################################################");
            System.out.println("Accounts not found in storage.");
            System.out.println("#######################################################\n");
        }
    }
}
