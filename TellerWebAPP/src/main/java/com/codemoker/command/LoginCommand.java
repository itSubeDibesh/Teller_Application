/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemoker.command;

/**
 *
 * @author kingr
 */
public class LoginCommand {

    private String userName;
    private String passWord;

    public LoginCommand() {
    }

    
    public LoginCommand(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

}
