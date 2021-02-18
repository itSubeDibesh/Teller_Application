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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value = {"/logout"})
    public String logout(Model m, HttpSession session) {
        session.removeAttribute("userName");
        return "redirect:login";
    }

    @RequestMapping(value = {"/loginProcess"}, method = RequestMethod.POST)
    public String loginProcess(@ModelAttribute("command") LoginCommand lc, Model m, HttpSession session) {
        if (ud.login(lc.getUserName(), lc.getPassWord())) {
            session.setAttribute("userName", lc.getUserName());
            return "redirect:dashboard";
        } else {
            m.addAttribute("message", "Invalid Login");
            return "login";
        }
    }

    @RequestMapping(value = {"/dashboard"})
    public String dash(Model m, HttpSession session) {
        if (session.getAttribute("userName") != null) {
            m.addAttribute("title", "Teller Application");
            m.addAttribute("message", "Login Success");
            return "dashboard";
        } else {
            return "redirect:login";
        }
    }

}
