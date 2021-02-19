/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemoker.controller;

import com.codemoker.command.AccountCommand;
import com.codemoker.dao.AccountDAO;
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
public class AccountsController {

    @Autowired
    AccountDAO ad;

    @RequestMapping("/createnewaccount")
    public String createAccount(Model m, HttpSession session) {
        String userName = (String) session.getAttribute("userName");
        if (userName != null) {
            m.addAttribute("title", "Teller Application | Create Account");
            m.addAttribute("account", new AccountCommand());
            return "createnewaccount";
        } else {
            m.addAttribute("message", "Invalid Login");
            return "redirect:logout";
        }
    }

    @RequestMapping(value = {"/processNewAccount"}, method = RequestMethod.POST)
    public String loginProcess(@ModelAttribute("account") AccountCommand uc, Model m, HttpSession session) {
        String userName = (String) session.getAttribute("userName");
        if (userName != null) {
            if (ad.addAccount(uc.getAccountNumber(), uc.getAccountName(), uc.getAccountBalance())) {
                m.addAttribute("message", "Account Added Successfully");
                return "redirect:dashboard";
            } else {
                m.addAttribute("message", "Invalid Account details");
                return "redirect:dashboard";
            }
        } else {
            m.addAttribute("message", "Invalid Login");
            return "redirect:logout";
        }
    }
}
