/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemoker.controller;

import com.codemoker.command.LoginCommand;
import com.codemoker.dao.UserDAO;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author kingr
 */
@Controller
public class UserController {

    @Autowired
    UserDAO ud;

    @RequestMapping(value = {"/login"})

    public String loginForm(Model m, HttpSession session) {
        m.addAttribute("command", new LoginCommand());
        session.invalidate();
        return "login";
    }

}
