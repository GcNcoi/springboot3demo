package com.example.boot3.r2dbc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 功能描述
 *
 * @author: Gxf
 * @date: 2025年06月11日 14:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

    private Long id;

    private String name;

    private String companyName;

}
