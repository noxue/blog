package com.noxue.utils.SsoClient;

/**
 * Created by noxue on 2017/3/3.
 */
public class Msg {
    private int code;
    private String msg;
    private Object errs;
    private User data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getErrs() {
        return errs;
    }

    public void setErrs(Object errs) {
        this.errs = errs;
    }

    public User getData() {
        return data;
    }

    public void setData(User data) {
        this.data = data;
    }
}