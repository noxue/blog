package com.noxue.utils;

import com.noxue.domain.Item;
import com.noxue.domain.Type;
import com.noxue.service.ItemService;


/**
 * Created by noxue on 2017/4/8.
 */
public class ItemEncoder implements Runnable {
    private ItemService itemService;
    private String urlName;
    private String url;

    public ItemEncoder(ItemService itemService, String url, String urlName) {
        this.itemService = itemService;
        this.urlName = urlName;
        this.url = url;
    }

    @Override
    public void run() {
        String html = Tools.getEditorHtml(url+"/item/html/"+urlName);
        Item item = itemService.GetItem(urlName);
        item.setContentHtml(html);
        itemService.SaveItem(item);
        System.out.println(html);
    }

}
