/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemoker.controller;

import com.codemoker.command.AccountCommand;
import com.codemoker.command.TransfureCommand;
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
        if (session.getAttribute("userName") != null) {
            m.addAttribute("account", new AccountCommand());
            return "createnewaccount";
        } else {
            return "redirect:logout";
        }
    }

    @RequestMapping(value = {"/processNewAccount"}, method = RequestMethod.POST)
    public String newAccountProcess(@ModelAttribute("account") AccountCommand uc, Model m, HttpSession session) {
        if (session.getAttribute("userName") != null) {
            if (ad.addAccount(uc.getAccountNumber(), uc.getAccountName(), uc.getAccountBalance())) {
                session.setAttribute("message", "Account Added Successfully");
            } else {
                session.setAttribute("message", "Account already exists");
            }
            return "redirect:createnewaccount";
        } else {
            return "redirect:logout";
        }
    }

    @RequestMapping("/deleteaccount")
    public String deleteAccount(Model m, HttpSession session) {
        if (session.getAttribute("userName") != null) {
            m.addAttribute("account", new AccountCommand());
            return "deleteaccount";
        } else {
            return "redirect:logout";
        }
    }

    @RequestMapping(value = {"/processdeleteaccount"}, method = RequestMethod.POST)
    public String deleteProcess(@ModelAttribute("account") AccountCommand uc, Model m, HttpSession session) {
        if (session.getAttribute("userName") != null) {
            if (ad.deleteAccount(uc.getAccountNumber())) {
                session.setAttribute("message", "Account Deleted Successfully");
            } else {
                session.setAttribute("message", "Account already exists");
            }
            return "redirect:createnewaccount";
        } else {
            return "redirect:logout";
        }
    }

    
    @RequestMapping("/depositamount")
    public String depositAmount(Model m, HttpSession session) {
        if (session.getAttribute("userName") != null) {
            m.addAttribute("account", new AccountCommand());
            return "depositamount";
        } else {
            return "redirect:logout";
        }
    }

    @RequestMapping(value = {"/processdeposit"}, method = RequestMethod.POST)
    public String depositAmountProcess(@ModelAttribute("account") AccountCommand uc, Model m, HttpSession session) {
        if (session.getAttribute("userName") != null) {
            float withdraw = ad.depositeAmount(uc.getAccountNumber(), uc.getAccountBalance());
            if (withdraw != 0) {
                // Withdraw
                session.setAttribute("message", "Amount Deposit Successfully");
            } else {
                // Balance insufficent
                session.setAttribute("message", "Tryagain Later");
            }
            return "redirect:createnewaccount";
        } else {
            return "redirect:logout";
        }
    }
    
    @RequestMapping("/withdraw")
    public String withdrawAmount(Model m, HttpSession session) {
        if (session.getAttribute("userName") != null) {
            m.addAttribute("account", new AccountCommand());
            return "withdraw";
        } else {
            return "redirect:logout";
        }
    }

    @RequestMapping(value = {"/processwithdraw"}, method = RequestMethod.POST)
    public String withdrawAmountProcess(@ModelAttribute("account") AccountCommand uc, Model m, HttpSession session) {
        if (session.getAttribute("userName") != null) {
            float withdraw = ad.withdrawAmount(uc.getAccountNumber(), uc.getAccountBalance());
            if (withdraw > 0) {
                // Withdraw
                session.setAttribute("message", "Amount Withdrawn Successfully");
            } else {
                // Balance insufficent
                session.setAttribute("message", "Insufficent Balance in account");
            }
            return "redirect:createnewaccount";
        } else {
            return "redirect:logout";
        }
    }

    @RequestMapping("/fundtransfure")
    public String transfuremount(Model m, HttpSession session) {
        if (session.getAttribute("userName") != null) {
            m.addAttribute("fundtransferhelper", new TransfureCommand());
            return "fundtransfer";
        } else {
            return "redirect:logout";
        }
    }

    @RequestMapping(value = {"/processfundtransfer"}, method = RequestMethod.POST)
    public String transfuremountProcess(@ModelAttribute("account") TransfureCommand tc, Model m, HttpSession session) {
        if (session.getAttribute("userName") != null) {
            int transfur = ad.transfureAmountA_to_B(tc.getSenderAccount(), tc.getReceiverAccount(), tc.getAmount());
            if (transfur == 1) {
                session.setAttribute("message", "Amount transfured Successfully");
            } else if (transfur == 0) {
                // Balance insufficent
                session.setAttribute("message", "Sender has insufficent balance");
            } else {
                // Accound Dont Exists
                session.setAttribute("message", "Enter Valid Account Number.");
            }
            return "redirect:createnewaccount";
        } else {
            return "redirect:logout";
        }
    }
    
       @RequestMapping("/listallaccounts")
    public String listAllAccounts(Model m, HttpSession session) {
        if (session.getAttribute("userName") != null) {
            m.addAttribute("aList", ad.ListAccounts());
            return "listallaccounts";
        } else {
            return "redirect:logout";
        }
    }

}
