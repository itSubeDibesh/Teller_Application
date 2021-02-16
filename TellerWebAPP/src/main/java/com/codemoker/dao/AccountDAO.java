/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemoker.dao;

import com.codemoker.domain.Acccounts;
import java.util.ArrayList;

/**
 *
 * @author kingr
 */
public interface AccountDAO {

    public boolean addAccount(int accountNumber, String accountName, float accountBalance);

    public Acccounts findAccount(int accountNumber);

    public float checkAmount(int accountNumber);

    public float depositeAmount(int accountNumber, float amount);

    public float withdrawAmount(int accountNumber, float amount);

    public int transfureAmountA_to_B(int senderAccount, int receiverAccount, float amount);

    public boolean deleteAccount(int accountNumber);

    public ArrayList<Acccounts> ListAccounts();
}
