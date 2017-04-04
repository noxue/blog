package com.noxue.service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by noxue on 2017/4/4.
 */
public interface UserService {

    /**
     * 根据配置信息，返回登陆地址
     * @return
     */
    public String GetLoginUrl();

    /**
     * 判断用户是否处于登陆状态
     * @param request
     * @return
     */
    public boolean CheckLogin(HttpServletRequest request);

    /**
     * 通过用户中心给的key，去用户中心检测是否合法
     * @param authkey
     * @return
     */
    public boolean Check(String authkey);
}
