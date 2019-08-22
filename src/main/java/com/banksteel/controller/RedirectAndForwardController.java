package com.banksteel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RedirectAndForwardController {

    @RequestMapping(value = {"test1"}, method = RequestMethod.GET)
    public String test1() {
        System.out.println("=================test1");

        return "test1";
    }

    @RequestMapping(value = "test2")
    public String test2() {
        System.out.println("================test2");

        return "redirect:test1";
    }

    @RequestMapping(value = "test3")
    public String test3() {
        System.out.println("================test3");

        return "forward:test2";
    }

}
