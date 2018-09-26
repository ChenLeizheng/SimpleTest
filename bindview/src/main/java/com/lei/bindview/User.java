package com.lei.bindview;

/**
 * Created by Lei on 2018/2/5.
 */

public class User {
    private String name;
    private String age;
    private String picUrl;

    public User(String name, String age, String picUrl) {
        this.name = name;
        this.age = age;
        this.picUrl = picUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", picUrl='" + picUrl + '\'' +
                '}';
    }
}
