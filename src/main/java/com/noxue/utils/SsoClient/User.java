package com.noxue.utils.SsoClient;

import java.util.Date;

/**
 * Created by noxue on 2017/4/8.
 */
public class User {
    private Integer id;

    private String nickname;

    private Byte sex;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

}
