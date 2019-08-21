package com.banksteel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.banksteel.bean.User;

/**
 * @author wukaifeng
 *
 */
@Controller
public class ConverterController {

    @RequestMapping(value="/testConversionServiceConverer")
    public String testConverter(@RequestParam("user") User user){
        System.out.println("save: "+user);
        
        return "redirect:/hello";
    }

}
