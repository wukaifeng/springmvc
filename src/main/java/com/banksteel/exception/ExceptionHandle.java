package com.banksteel.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class ExceptionHandle implements HandlerExceptionResolver {

    public ModelAndView resolveException(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
        Exception arg3) {
        System.out.println("HandlerExceptionResolver:" );
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorMsg", arg3);
        return modelAndView;
    }

}
