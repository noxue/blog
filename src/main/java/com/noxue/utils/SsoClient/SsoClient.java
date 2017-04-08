package com.noxue.utils.SsoClient;

import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by noxue on 2017/4/8.
 */
public class SsoClient {
    private String ssourl;
    private String appid;
    private String appkey;

    public SsoClient(String ssourl, String appid, String appkey) {
        this.ssourl = ssourl;
        this.appid = appid;
        this.appkey = appkey;
    }

    public Msg Check(String authKey) {
        String url = ssourl+"?appid="+appid+"&appkey="+appkey+"&authkey="+authKey;

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

        Gson gson = new Gson();
        Msg msg = gson.fromJson(html,Msg.class);

        return msg;
    }
}
