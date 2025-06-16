package com.example.demo.config;

import com.example.demo.component.MyYamlHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * 功能描述
 *
 * @author: Gxf
 * @date: 2025年05月23日 11:43
 */
@Configuration
public class MyConfig implements WebMvcConfigurer {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new MyYamlHttpMessageConverter());
    }
}
