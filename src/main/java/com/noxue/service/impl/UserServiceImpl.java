package com.noxue.service.impl;

import com.noxue.service.UserService;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by noxue on 2017/4/4.
 */
@Service
public class UserServiceImpl implements UserService {

    @Value("${sso.login.url}")
    private String  LOGIN_URL;

    @Value("${sso.login.check.url}")
    private String CHECK_URL;

    @Value("${sso.appid}")
    private String APPIID;

    @Value("${sso.appkey}")
    private String APPKEY;
    @Override
    public String GetLoginUrl() {
        return LOGIN_URL;
    }

    @Override
    public boolean CheckLogin(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String admin = (String)session.getAttribute("admin");
        return "admin".equalsIgnoreCase(admin);
    }

    @Override
    public boolean Check(String authkey) {
        String url = CHECK_URL+"?appid="+APPIID+"&appkey="+APPKEY+"&authkey="+authkey;

        String html = null;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        try {
            CloseableHttpResponse response1 = httpclient.execute(httpGet);
            try {
                System.out.println(response1.getStatusLine());
                HttpEntity entity1 = response1.getEntity();

                html = EntityUtils.toString(entity1);
            } finally {
                response1.close();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(html);

        //如果是管理员登陆，那么就返回true
        if(html!=null && html.contains("\"nickname\":\"admin\"")) {
            return true;
        }

        return false;
    }
}
