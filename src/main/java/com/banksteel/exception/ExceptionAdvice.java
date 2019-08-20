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

//    /**
//     * 400 - Bad Request
//     */
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(HttpMessageNotReadableException.class)
//    public ServiceResponse handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
//        System.out.println("参数解析失败" + e);
//        return ServiceResponseHandle.failed("could_not_read_json");
//    }
//
//    /**
//     * 405 - Method Not Allowed
//     */
//    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
//    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
//    public ServiceResponse handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
//        System.out.println("不支持当前请求方法" + e);
//        return ServiceResponseHandle.failed("request_method_not_supported");
//    }
//
//    /**
//     * 415 - Unsupported Media Type
//     */
//    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
//    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
//    public ServiceResponse handleHttpMediaTypeNotSupportedException(Exception e) {
//        System.out.println("不支持当前媒体类型" + e);
//        return ServiceResponseHandle.failed("content_type_not_supported");
//    }
//
//    /**
//     * 500 - Internal Server Error
//     */
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ExceptionHandler(Exception.class)
//    public ServiceResponse handleException(Exception e) {
//        if (e instanceof BusinessException) {
//            return ServiceResponseHandle.failed("BUSINESS_ERROR", e.getMessage());
//        }
//
//        System.out.println("服务运行异常" + e);
//        return ServiceResponseHandle.failed("server_error");
//    }

}
