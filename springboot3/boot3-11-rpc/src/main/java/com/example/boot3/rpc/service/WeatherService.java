package com.example.boot3.rpc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述
 *
 * @author: Gxf
 * @date: 2025年06月03日 10:14
 */
@Service
public class WeatherService {

    @Autowired
    private WeatherInterface weatherAPI;

    public Mono<String> weather(String city) {
        Mono<String> weather = weatherAPI.getWeather(city);
        return weather;
    }

    private static Mono<String> getByWebClient(String city) {
        Map<String, String> param = new HashMap<>();
        param.put("area", city);
        WebClient webClient = WebClient.create();
        Mono<String> mono = webClient.get()
                .uri("https://ali-weather.showapi.com/area-to-weather-date?area={area}", param)
                .accept(MediaType.APPLICATION_JSON)
                .header("Authorization", "APPCODE b2a0f3600cc849d4a656fe2f41a160be")
                .retrieve()
                .bodyToMono(String.class);
        return mono;
    }
}
