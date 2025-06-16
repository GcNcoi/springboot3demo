package com.example.demo.bean;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 功能描述
 *
 * @author: Gxf
 * @date: 2025年05月23日 11:23
 */
@JacksonXmlRootElement
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private String role;
}
