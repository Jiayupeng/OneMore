package com.jypure.demo.model;

import java.io.Serializable;

/**
 * @author : jiayupeng
 * @date : 2020/5/24/12:54
 */
public class Person implements Serializable {

    private String name;

    private Integer age;

    private String address;

    private Double score;

    private Long uid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }
}
