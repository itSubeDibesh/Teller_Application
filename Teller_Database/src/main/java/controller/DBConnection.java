/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kingr
 */

package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private String classname = "com.mysql.jdbc.Driver"; 
    private String url="jdbc:mysql://localHost:3306/tellerdb";
    private String dbUser="root";
    private String dbPassword="password";
    
    public DBConnection(){
        try{
            Class.forName(classname);
            con = DriverManager.getConnection(url,dbUser,dbPassword);
            System.out.println("Connected");
        }catch(ClassNotFoundException ex){
            System.out.println("Driver File Not Found");
        }catch(SQLException ex){
            System.out.println("Problem Connecting");
            
        }
    }
}
