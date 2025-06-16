package com.example.boot3.rpc.config;

import com.example.boot3.rpc.service.LogisticsInterface;
import com.example.boot3.rpc.service.SmsInterface;
import com.example.boot3.rpc.service.WeatherInterface;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

/**
 * 功能描述
 *
 * @author: Gxf
 * @date: 2025年06月03日 11:06
 */
@Configuration
public class WeatherConfiguration {

    @Bean
    HttpServiceProxyFactory httpServiceProxyFactory(@Value("${aliyun.appcode}") String appcode) {
        WebClient client = WebClient.builder()
                .defaultHeader("Authorization", "APPCODE " + appcode)
                .codecs(clientCodecConfigurer -> {
                    clientCodecConfigurer
                            .defaultCodecs()
                            .maxInMemorySize(256 * 1024 * 1024);
                })
                .build();

        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(client)).build();
        return factory;
    }

    @Bean
    WeatherInterface weatherInterface(HttpServiceProxyFactory factory) {
        WeatherInterface weatherAPI = factory.createClient(WeatherInterface.class);
        return weatherAPI;
    }

    @Bean
    SmsInterface smsInterface(HttpServiceProxyFactory factory) {
        SmsInterface smsAPI = factory.createClient(SmsInterface.class);
        return smsAPI;
    }

    @Bean
    LogisticsInterface logisticsInterface(HttpServiceProxyFactory factory) {
        LogisticsInterface logisticsAPI = factory.createClient(LogisticsInterface.class);
        return logisticsAPI;
    }

}
