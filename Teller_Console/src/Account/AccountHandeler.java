package Account;

import java.util.ArrayList;

public class AccountHandeler {
    public ArrayList<AcccountClass> accountsList = new ArrayList<>();
    
    // Add Accounts
    public boolean addAccount(int accountNumber, String accountName, float accountBalance) {
        AcccountClass account = new AcccountClass(accountNumber, accountName, accountBalance);
        if (findAccount(accountNumber) == null) {
            this.accountsList.add(account);
            return true;
        }
        return false;
    }

    // Find Accounts
    public AcccountClass findAccount(int accountNumber) {
        // Foreach Loop to Check if th eaccount number exists in array list
        for (AcccountClass account : accountsList) {
            if (account.getAccountNumber() == accountNumber)
                return account;
        }
        return null;
    }

    // Check Amount
    public float checkAmount(int accountNumber) {
        // Store the search to account to avoide double search
        AcccountClass account = findAccount(accountNumber);
        if (account != null)
            return account.getAccountBalance();
        return 0;
    }

    // Deposite Amount
    public float depositeAmount(int accountNumber, float amount) {
        // Store the search to account to avoide double search
        AcccountClass account = findAccount(accountNumber);
        if (account != null) {
            account.setAccountBalance(account.getAccountBalance() + amount);
            return account.getAccountBalance();
        }
        return 0;
    }

    // WithDraw Amount
    public float withdrawAmount(int accountNumber, float amount) {
        // Store the search to account to avoide double search
        AcccountClass account = findAccount(accountNumber);
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
        AcccountClass account_A = findAccount(senderAccount);
        AcccountClass account_B = findAccount(receiverAccount);
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
        AcccountClass account = findAccount(accountNumber);
        if (account != null) {
            this.accountsList.remove(account);
            return true;
        }
        return false;
    }

    // Returns Account List
    public ArrayList<AcccountClass> ListAccounts() {
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
