package com.zhou.ajax;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.ArrayList;
import java.util.List;

/**
 * 周刘成   2019-12-20
 */
@XStreamAlias("province")
public class Province {
    @XStreamAsAttribute
    private int code;
    @XStreamAsAttribute
    private String name;
    @XStreamImplicit(itemFieldName = "city")
    private List<City> cities = new ArrayList<>();

    public Province() {
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public Province(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public Province(int code, String name, List<City> cities) {
        this.code = code;
        this.name = name;
        this.cities = cities;
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
