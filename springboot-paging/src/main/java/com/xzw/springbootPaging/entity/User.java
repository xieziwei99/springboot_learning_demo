package com.xzw.springbootPaging.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author xieziwei99
 * 2019-06-29
 */
@Entity
@Data
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private Integer age;
    private String birthday;
}
