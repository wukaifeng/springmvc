package com.banksteel.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
@ControllerAdvice
public class ExceptionAdvice {

  @ExceptionHandler({Exception.class})
  public String testRuntimeException(Exception e) {
      System.out.println(" ExceptionAdvice-RuntimeException" + e);
      return "error";
  }
}
