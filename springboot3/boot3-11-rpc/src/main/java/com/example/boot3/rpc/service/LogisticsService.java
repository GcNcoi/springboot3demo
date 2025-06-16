package com.example.boot3.rpc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Random;

/**
 * 功能描述
 *
 * @author: Gxf
 * @date: 2025年06月03日 15:20
 */
@Service
public class LogisticsService {

    @Autowired
    LogisticsInterface logisticsInterface;

    public Mono<String> getLogistics(String expressNo) {
        Mono<String> logistics = logisticsInterface.getLogistics(expressNo);
        return logistics;
    }

}
