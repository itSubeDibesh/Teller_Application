package Account;
/**
 * Store and Access Account Details From Here
 */
public class AcccountClass {
    // #region Variable Declaration
    private int accountNumber;
    private String accountName;
    private float accountBalance;
    // #endregion

    public AcccountClass(int accountNumber, String accountName, float accountBalance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.accountBalance = accountBalance;
    }

    // #region Account Number
    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    // #endregion

    // #region Account Name
    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    // #endregion

    // #region Account Balance
    public float getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(float accountBalance) {
        this.accountBalance = accountBalance;
    }
    // #endregion
}
