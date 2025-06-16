package com.example.demo.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

/**
 * 功能描述
 *
 * @author: Gxf
 * @date: 2025年05月23日 14:36
 */
public class MyYamlHttpMessageConverter extends AbstractHttpMessageConverter {

    private ObjectMapper objectMapper = null;

    public MyYamlHttpMessageConverter() {
        super(new MediaType("text", "yaml", Charset.forName("UTF-8")));
        YAMLFactory yamlFactory = new YAMLFactory()
                .disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER);
        this.objectMapper = new ObjectMapper(yamlFactory);
    }

    @Override
    protected boolean supports(Class clazz) {
        return true;
    }

    @Override
    protected Object readInternal(Class clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    @Override
    protected void writeInternal(Object methodReturnValue, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        try (OutputStream os = outputMessage.getBody()){
            this.objectMapper.writeValue(os, methodReturnValue);
        }
    }
}
