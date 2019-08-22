package com.banksteel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * springmvc 处理异常的三种方式 1， @ExceptionHandler 注解标注 ExceptionHandler的优先级是：在异常的体系结构中，哪个异常与目标方法抛出的异常血缘关系越紧密，就会被哪个捕捉到。
 * ExceptionHandler只能捕捉同一个controller中的异常，其实我们也有办法捕捉整个程序中所有的异常
 * 传递错误信息到前台不能使用map，只能使用modelAndView
 * 2、实现接口 
 * 这种方式可以进行全局的异常控制， HandlerExceptionResolver
 * 3、@ControllerAdvice 注解
 * 
 * @author wukaifeng
 *
 */
@Controller
public class ExceptionController {

    @ExceptionHandler({ArithmeticException.class})
    public ModelAndView testArithmeticException(Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errorMsg", e);
        modelAndView.setViewName("error");
        System.out.println("testArithmeticException-ArithmeticException:" + e);
        return modelAndView;
    }

    @ExceptionHandler({RuntimeException.class})
    public String testRuntimeException(Exception e) {
        System.out.println(" testRuntimeException-RuntimeException" + e);
        return "error";
    }
//    @ExceptionHandler({ArithmeticException.class})
//    public ModelAndView testArithmeticException(Exception e) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("errorMsg", e);
//        modelAndView.setViewName("error");
//        System.out.println("testArithmeticException-ArithmeticException:" + e);
//        return modelAndView;
//    }
//
//    @ExceptionHandler({RuntimeException.class})
//    public String testRuntimeException(Exception e) {
//        System.out.println(" testRuntimeException-RuntimeException" + e);
//        return "error";
//    }

    @RequestMapping(value = "testException/{i}", method = RequestMethod.GET)
    public String testException1(@PathVariable(value = "i") int i) {
        i = 10 / i;
        System.out.println("i:" + i);
        return "success";
    }

}
