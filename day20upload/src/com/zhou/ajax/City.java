package com.zhou.ajax;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * 周刘成   2019-12-20
 */
@XStreamAlias("city")
public class City {
    @XStreamAsAttribute
    private int code;
    @XStreamAsAttribute
    private String name;

    public City() {
    }

    public City(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
