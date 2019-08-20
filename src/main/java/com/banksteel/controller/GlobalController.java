package com.banksteel.controller;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.RequestContext;

/**
 * @CookieValue cookie 值
 * @RequestHeader 请求头
 * @author wukaifeng123
 *
 */

@Controller
public class GlobalController {

    @RequestMapping(value = "/testI18n", method = {RequestMethod.GET})
    public String test(HttpServletRequest request, Model model) {

        // 从后台代码获取国际化信息
        RequestContext requestContext = new RequestContext(request);
        model.addAttribute("username", requestContext.getMessage("username"));
        model.addAttribute("password", requestContext.getMessage("password"));

        model.addAttribute("username", 12345.678);
        model.addAttribute("password", new Date());
        
        return "globaltest";
    }

}
