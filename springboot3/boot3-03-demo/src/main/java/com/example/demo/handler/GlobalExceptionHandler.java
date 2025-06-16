package com.example.demo.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 功能描述
 *
 * @author: Gxf
 * @date: 2025年05月23日 17:44
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String exceptionHandler(Exception e){
        return "出错了,进行统一处理,原因是因为:" + e.getMessage();
    }

}
