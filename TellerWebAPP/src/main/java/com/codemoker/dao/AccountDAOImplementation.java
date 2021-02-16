/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemoker.dao;

import static com.codemoker.dao.DatabaseVariable.db;
import com.codemoker.domain.Acccounts;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kingr
 */
@Repository
public class AccountDAOImplementation implements AccountDAO {

    @Override
    public boolean addAccount(int accountNumber, String accountName, float accountBalance) {
         //To change body of generated methods, choose Tools | Templates.
          if (findAccount(accountNumber) == null) {
            String sql = "INSERT INTO `tellerdb`.`account` (`accountNumber`,`accountName`,`accountBalance`) VALUES (" + accountNumber + ",'" + accountName + "'," + accountBalance + ");";
            return db.iud(sql);
        }
        return false;
    }

    @Override
    public Acccounts findAccount(int accountNumber) {
         //To change body of generated methods, choose Tools | Templates.
          String sql = "SELECT * FROM `tellerdb`.`account` WHERE `account`.`accountNumber` = " + accountNumber + ";";
        ResultSet rs = db.select(sql);
        try {
            if (rs != null) {
                while (rs.next()) {
                    Acccounts ac = new Acccounts(rs.getInt(1), rs.getString(2), rs.getFloat(3));
                    return ac;
                }
            } else {
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
        return null;
    }

    @Override
    public float checkAmount(int accountNumber) {
         //To change body of generated methods, choose Tools | Templates.
          Acccounts account = findAccount(accountNumber);
        if (account != null) {
            return account.getAccountBalance();
        }
        return 0;
    }

    @Override
    public float depositeAmount(int accountNumber, float amount) {
       //To change body of generated methods, choose Tools | Templates.
        Acccounts account = findAccount(accountNumber);
        if (account != null) {
            account.setAccountBalance(account.getAccountBalance() + amount);
            String sql = "UPDATE `tellerdb`.`account` SET `accountBalance` = '" + account.getAccountBalance() + "' WHERE `account`.`accountNumber` = " + accountNumber + ";";
            if (db.iud(sql)) {
                return account.getAccountBalance();
            }
            return 0;
        }
        return 0;
    }

    @Override
    public float withdrawAmount(int accountNumber, float amount) {
        //To change body of generated methods, choose Tools | Templates.
         Acccounts account = findAccount(accountNumber);
        if (account != null) {
            // Accounts Exists
            if (account.getAccountBalance() >= amount) {
                // Withdraw
                account.setAccountBalance(account.getAccountBalance() - amount);
                String sql = "UPDATE `tellerdb`.`account` SET `accountBalance` = '" + account.getAccountBalance() + "' WHERE `account`.`accountNumber` = " + accountNumber + ";";
                if (db.iud(sql)) {
                    return account.getAccountBalance();
                }
                return 0;
            }
            return 0;
        }
        return -1;
    }

    @Override
    public int transfureAmountA_to_B(int senderAccount, int receiverAccount, float amount) {
        //To change body of generated methods, choose Tools | Templates.
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

    @Override
    public boolean deleteAccount(int accountNumber) {
       //To change body of generated methods, choose Tools | Templates.
        Acccounts account = findAccount(accountNumber);
        if (account != null) {
            String sql = "DELETE FROM `tellerdb`.`account` WHERE `account`.`accountNumber` = '" + accountNumber + "';";
            return db.iud(sql);
        }
        return false;
    }

    @Override
    public ArrayList<Acccounts> ListAccounts() {
        //To change body of generated methods, choose Tools | Templates.
         String sql = "SELECT * FROM `tellerdb`.`account`;";
        ResultSet rs = db.select(sql);
        ArrayList<Acccounts> list = new ArrayList<>();
        list.clear();
        try {
            while (rs.next()) {
                Acccounts accounts = new Acccounts(rs.getInt(1), rs.getString(2), rs.getFloat(3));
                list.add(accounts);
            }
            return list;
        } catch (SQLException ex) {
            return null;
        }
    }
    
}
