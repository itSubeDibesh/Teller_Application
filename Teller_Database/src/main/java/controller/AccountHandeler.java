package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Acccounts;

public class AccountHandeler {

    public ArrayList<Acccounts> accountsList = new ArrayList<>();
    DBConnection db = new DBConnection();

    // Add Accounts
    public boolean addAccount(int accountNumber, String accountName, float accountBalance) {
        Acccounts account = new Acccounts(accountNumber, accountName, accountBalance);
        if (findAccount(accountNumber) == null) {
            String sql = "INSERT INTO `tellerdb`.`account` (`accountNumber`,`accountName`,`accountBalance`) VALUES (" + accountNumber + ",'" + accountName + "'," + accountBalance + ");";
            return db.iud(sql);
        }
        return false;
    }

    // Find Accounts
    public Acccounts findAccount(int accountNumber) {
        String sql = "SELECT * FROM `tellerdb`.`account` WHERE `account`.`accountNumber` = " + accountNumber + ";";
        ResultSet rs = db.select(sql);
        try {
            while (rs.next()) {
                Acccounts ac = new Acccounts(rs.getInt(1), rs.getString(2), rs.getFloat(3));
                return ac;
            }
        } catch (SQLException ex) {
            return null;
        }
        return null;
    }

    // Check Amount
    public float checkAmount(int accountNumber) {
        // Store the search to account to avoide double search
        Acccounts account = findAccount(accountNumber);
        if (account != null) {
            return account.getAccountBalance();
        }
        return 0;
    }

    // Deposite Amount
    public float depositeAmount(int accountNumber, float amount) {
        // Store the search to account to avoide double search
        Acccounts account = findAccount(accountNumber);
        if (account != null) {
            account.setAccountBalance(account.getAccountBalance() + amount);
            return account.getAccountBalance();
        }
        return 0;
    }

    // WithDraw Amount
    public float withdrawAmount(int accountNumber, float amount) {
        // Store the search to account to avoide double search
        Acccounts account = findAccount(accountNumber);
        if (account != null) {
            // Accounts Exists
            if (account.getAccountBalance() >= amount) {
                // Withdraw
                account.setAccountBalance(account.getAccountBalance() - amount);
                return account.getAccountBalance();
            }
            return 0;
        }
        return -1;
    }

    // Transfur Amount
    public int transfureAmountA_to_B(int senderAccount, int receiverAccount, float amount) {
        // Store the search to account to avoide double search
        Acccounts account_A = findAccount(senderAccount);
        Acccounts account_B = findAccount(receiverAccount);
        if (account_A != null && account_B != null) {
            if (account_A.getAccountBalance() >= amount) {
                // Withdraw from a
                withdrawAmount(senderAccount, amount);
                // Deposit into b
                depositeAmount(receiverAccount, amount);
                return 1;
            }
            return 0;
        }
        return -1;
    }

    // Delete Account
    public boolean deleteAccount(int accountNumber) {
        // Store the search to account to avoide double search
        Acccounts account = findAccount(accountNumber);
        if (account != null) {
            this.accountsList.remove(account);
            return true;
        }
        return false;
    }

    // Returns Account List
    public ArrayList<Acccounts> ListAccounts() {
        return accountsList;
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
