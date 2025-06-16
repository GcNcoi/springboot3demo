package com.example.boot3.rpc.controller;

import com.example.boot3.rpc.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * 功能描述
 *
 * @author: Gxf
 * @date: 2025年06月03日 11:21
 */
@RestController
public class SmsController {

    @Autowired
    private SmsService smsService;

    @GetMapping("/Sms")
    public Mono<String> sendSms(@RequestParam("mobile") String mobile) {
        Mono<String> sms = smsService.sendSms(mobile);
        return sms;
    }

}
