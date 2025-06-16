package com.example.boot3.rpc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Random;

/**
 * 功能描述
 *
 * @author: Gxf
 * @date: 2025年06月03日 11:18
 */
@Service
public class SmsService {

    @Autowired
    private SmsInterface smsInterface;

    public Mono<String> sendSms(String mobile) {
        Random random = new Random();
        int code = random.nextInt(900000) + 100000;
        Mono<String> sms = smsInterface.getSms(mobile, "908e94ccf08b4476ba6c876d13f084ad", "2e65b1bb3d054466b82f0c9d125465e2", "**code**:" + code + ",**minute**:5");
        return sms;
    }

}
