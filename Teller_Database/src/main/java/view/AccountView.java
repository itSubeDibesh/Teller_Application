package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.AccountHandeler;
import model.Acccounts;

public class AccountView {
    // Instiantiating Accounts Handler to invoke its methords

    public AccountHandeler accounts = new AccountHandeler();

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
        if (accounts.addAccount(accountNumber, accountName, accountBalance)) {
            accounts.printInLine("\tAccount Added Successfully");
        } else {
            accounts.printInLine("\tAccount Already Exists");
        }
    }

    // Checks Amount
    public void checkAmountView() {
        System.out.println("Enter Account Number:");
        int accountNumber = input.nextInt();
        Acccounts account = accounts.findAccount(accountNumber);
        float amount = accounts.checkAmount(accountNumber);
        if (account != null) {
            if (amount != 0) {
                accounts.printInLine("Account Number " + account.getAccountNumber() + " has balance of Rs: " + amount + "/-");
            } else {
                accounts.printInLine("Account Number " + account.getAccountNumber() + " has no baance left.");
            }
        } else {
            accounts.printInLine("\tEnter Valid Account Number.");
        }
    }

    // Deposits Amount
    public void depositAmountView() {
        System.out.println("Enter Account Number:");
        int accountNumber = input.nextInt();
        System.out.println("Enter Deposite Balance:");
        float amount = input.nextFloat();
        Acccounts account = accounts.findAccount(accountNumber);
        float depositAmount = accounts.depositeAmount(accountNumber, amount);
        if (account != null) {
            if (depositAmount != 0) {
                accounts.printInLine("New Deposite Request of Rs: " + amount + "/- on Account number "
                        + account.getAccountNumber() + ".\n" + "Account Number " + account.getAccountNumber()
                        + " has new balance of Rs: " + depositAmount + "/-");
            } else {
                accounts.printInLine("\tProblem With Server Please Try again later.");
            }
        } else {
            accounts.printInLine("\tEnter Valid Account Number.");
        }
    }

    // Withdraw Amount
    public void withdrawAmountView() {
        System.out.println("Enter Account Number:");
        int accountNumber = input.nextInt();
        System.out.println("Enter Withdraw Balance:");
        float amount = input.nextFloat();
        Acccounts account = accounts.findAccount(accountNumber);
        float withdraw = accounts.withdrawAmount(accountNumber, amount);
        if (account != null) {
            // Accounts Exists
            if (withdraw > 0) {
                // Withdraw
                accounts.printInLine("New Withdraw Request of Rs: " + amount + "/-on Account number "
                        + account.getAccountNumber() + ".\n" + "Account Number " + account.getAccountNumber()
                        + " has new balance of Rs: " + withdraw + "/-");
            } else {
                // Balance insufficent
                accounts.printInLine("Account Number " + account.getAccountNumber() + " has insufficent balance(Rs "
                        + account.getAccountBalance() + "/-) to withdraw(Rs " + amount + "/-).");
            }
        } else {
            // Accound Dont Exists
            accounts.printInLine("\tEnter Valid Account Number.");
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
        Acccounts account_A = accounts.findAccount(senderAccount);
        Acccounts account_B = accounts.findAccount(receiverAccount);
        int transfur = accounts.transfureAmountA_to_B(senderAccount, receiverAccount, amount);
        if (transfur == 1) {
            accounts.printInLine("New Withdraw Request of Rs: " + amount + "/- on Account number " + account_A.getAccountNumber()
                    + ".\n" + "New Deposite Request of Rs: " + amount + "/- on Account number "
                    + account_B.getAccountNumber() + ".\n" + "Sender Account Number " + account_A.getAccountNumber()
                    + " has new balance of Rs: " + (account_A.getAccountBalance() - amount) + "/-\n" + "Receiver Account Number "
                    + account_B.getAccountNumber() + " has new balance of Rs: " + (account_B.getAccountBalance() + amount) + "/-");
        } else if (transfur == 0) {
            // Balance insufficent
            accounts.printInLine("Sender Account Number " + account_A.getAccountNumber() + " has insufficent balance(Rs "
                    + account_A.getAccountBalance() + "/-) to withdraw(Rs " + amount + "/-).");
        } else {
            // Accound Dont Exists
            accounts.printInLine("\tEnter Valid Account Number.");
        }
    }

    // Display All Account
    public void allAccountsView() {
        ArrayList<Acccounts> accountList = accounts.ListAccounts();
        int size = accountList.size();
        if (size != 0) {
            // Accounts Exists
            accounts.printInLine(size + " " + (size == 1 ? "account" : "accounts") + " found and listed below.");
            int count = 1;
            for (Acccounts account : accountList) {
                System.out.println(count++ + "-> Account Number: " + account.getAccountNumber() + " |  Account Name: "
                        + account.getAccountName() + " | Account Balance: Rs " + account.getAccountBalance() + "/-");
            }
            System.out.println("#######################################################\n");
        } else {
            // Accounts Dont Exist
            accounts.printInLine("\tAccounts not found in storage.");
        }
    }

    // Deletes Selected Account
    public void deleteAccount() {
        System.out.println("Enter Account Number:");
        int accountNumber = input.nextInt();
        if (accounts.deleteAccount(accountNumber)) {
            accounts.printInLine("\tAccounts Deleted Successfully.");
        } else {
            accounts.printInLine("\tAccounts not found in storage.");
        }
    }

}
