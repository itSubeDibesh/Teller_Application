package Account;

import java.util.ArrayList;
import java.util.Scanner;

public class AccountView {
    // Instiantiating Account Handler to invoke its methords
    public AccountHandeler storage = new AccountHandeler();

    // Defining Input Scanner
    Scanner input = new Scanner(System.in);

    // Adds Account
    public void addAccountView() {
        System.out.println("Enter Account Number:");
        int accountNumber = input.nextInt();
        System.out.println("Enter Account Name:");
        String accountName = input.next();
        System.out.println("Enter Opeaning Balance:");
        float accountBalance = input.nextFloat();
        // Check if Account Added
        if (storage.addAccount(accountNumber, accountName, accountBalance))
            printInLine("Account Added Successfully");
        else
            printInLine("Account Already Exists");
    }

    // Checks Amount
    public void checkAmountView() {
        System.out.println("Enter Account Number:");
        int accountNumber = input.nextInt();
        AcccountClass account = storage.findAccount(accountNumber);
        float amount = storage.checkAmount(accountNumber);
        if (account != null) {
            if (amount != 0)
                printInLine("Account Number " + account.getAccountNumber() + " has balance of Rs: " + amount + "/-");
            else
                printInLine("Account Number " + account.getAccountNumber() + " has no baance left.");
        } else
            printInLine("Enter Valid Account Number.");
    }

    // Deposits Amount
    public void depositAmountView() {
        System.out.println("Enter Account Number:");
        int accountNumber = input.nextInt();
        System.out.println("Enter Deposite Balance:");
        float amount = input.nextFloat();
        AcccountClass account = storage.findAccount(accountNumber);
        float depositAmount = storage.depositeAmount(accountNumber, amount);
        if (account != null) {
            if (depositAmount != 0)
                printInLine("New Deposite Request of Rs: " + amount + "/- on Account number "
                        + account.getAccountNumber() + ".\n" + "Account Number " + account.getAccountNumber()
                        + " has new balance of Rs: " + depositAmount + "/-");
            else
                printInLine("Problem With Server Please Try again later.");
        } else
            printInLine("Enter Valid Account Number.");
    }

    // Withdraw Amount
    public void withdrawAmountView() {
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
                printInLine("New Withdraw Request of Rs: " + amount + "/-on Account number "
                        + account.getAccountNumber() + ".\n" + "Account Number " + account.getAccountNumber()
                        + " has new balance of Rs: " + withdraw + "/-");
            } else {
                // Balance insufficent
                printInLine("Account Number " + account.getAccountNumber() + " has insufficent balance(Rs "
                        + account.getAccountBalance() + "/-) to withdraw(Rs " + amount + "/-).");
            }
        } else {
            // Accound Dont Exists
            printInLine("Enter Valid Account Number.");
        }
    }

    // Transfure Amount
    public void transfurAmountView() {
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
            printInLine("New Withdraw Request of Rs: " + amount + "/- on Account number " + account_A.getAccountNumber()
                    + ".\n" + "New Deposite Request of Rs: " + amount + "/- on Account number "
                    + account_B.getAccountNumber() + ".\n" + "Sender Account Number " + account_A.getAccountNumber()
                    + " has new balance of Rs: " + account_A.getAccountBalance() + "/-\n" + "Receiver Account Number "
                    + account_B.getAccountNumber() + " has new balance of Rs: " + account_B.getAccountBalance() + "/-");
        } else if (transfur == 0) {
            // Balance insufficent
            printInLine("Sender Account Number " + account_A.getAccountNumber() + " has insufficent balance(Rs "
                    + account_A.getAccountBalance() + "/-) to withdraw(Rs " + amount + "/-).");
        } else {
            // Accound Dont Exists
            printInLine("Enter Valid Account Number.");
        }
    }

    // Display All Account
    public void allAccountsView() {
        ArrayList<AcccountClass> accountList = storage.accountsList;
        int size = accountList.size();
        if (size != 0) {
            // Accounts Exists
            printInLine(size + " " + (size == 1 ? "account" : "accounts") + " found and listed below.");
            int count = 1;
            for (AcccountClass account : accountList) {
                System.out.println(count++ + "-> Account Number: " + account.getAccountNumber() + " |  Account Name: "
                        + account.getAccountName() + " | Account Balance: Rs " + account.getAccountBalance() + "/-");
            }
            System.out.println("#######################################################\n");
        } else {
            // Accounts Dont Exist
            printInLine("Accounts not found in storage.");
        }
    }

    // Deletes Selected Account
    public void deleteAccount() {
        System.out.println("Enter Account Number:");
        int accountNumber = input.nextInt();
        if (storage.deleteAccount(accountNumber))
            printInLine("Accounts Deleted Successfully.");
        else
            printInLine("Accounts not found in storage.");
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
