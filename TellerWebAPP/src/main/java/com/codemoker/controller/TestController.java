/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemoker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author kingr
 */
@Controller
public class TestController {

    @RequestMapping("/test")
    public String helloWorld() {
        return "hello";
    }
}
