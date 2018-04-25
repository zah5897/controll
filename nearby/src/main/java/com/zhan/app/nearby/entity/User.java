package com.zhan.app.nearby.entity;

import com.zhan.app.nearby.enums.UserGender;

/**
 * Created by zah on 2017/12/20.
 */
public class User {
    private int id;
    private String name;
    private String nickname;
    private String password;
    private UserGender gender;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserGender getGender() {
        return gender;
    }

    public void setGender(UserGender gender) {
        this.gender = gender;
    }
}
