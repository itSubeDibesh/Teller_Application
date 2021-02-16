/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemoker.dao;

import com.codemoker.controller.DBConnection;

/**
 *
 * @author kingr
 */
public interface DatabaseVariable {
    public static final DBConnection db = new DBConnection();
}
