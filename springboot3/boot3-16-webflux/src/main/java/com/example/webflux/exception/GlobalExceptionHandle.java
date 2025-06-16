package com.example.webflux.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 功能描述
 *
 * @author: Gxf
 * @date: 2025年06月11日 10:38
 */
@RestControllerAdvice
public class GlobalExceptionHandle {

    @ExceptionHandler(ArithmeticException.class)
    public String error(ArithmeticException e) {
        System.out.println("发生数学运算异常" + e);
        return "error炸了....";
    }

}
