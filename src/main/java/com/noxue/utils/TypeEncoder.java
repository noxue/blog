package com.noxue.utils;

import com.noxue.domain.Type;
import com.noxue.service.ItemService;


/**
 * Created by noxue on 2017/4/8.
 */
public class TypeEncoder implements Runnable {
    private ItemService itemService;
    private String urlName;
    private String url;

    public TypeEncoder(ItemService itemService, String url, String urlName) {
        this.itemService = itemService;
        this.urlName = urlName;
        this.url = url;
    }

    @Override
    public void run() {
        String html = Tools.getEditorHtml(url+"/type/html/"+urlName);
        Type type = itemService.GetType(urlName);
        type.setContentHtml(html);
        itemService.SaveType(type);
        System.out.println(html);
    }
}
