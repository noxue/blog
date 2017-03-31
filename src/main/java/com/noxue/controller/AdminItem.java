package com.noxue.controller;

import com.noxue.domain.Item;
import com.noxue.domain.Type;
import com.noxue.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by noxue on 2017/3/29.
 */
@RequestMapping(value = "/admin")
@Controller
@EnableAutoConfiguration
public class AdminItem {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/")
    public String home() {
//        for(long i=1; i<10; i++) {
//            Item item = new Item();
//            item.setTypeId(i);
//            item.setTitle("title"+i);
//            item.setUrlName("url"+i);
//            item.setContentText("contentText"+i);
//            item.setOrderId(((int) i));
//
//            Long id  = itemService.SaveItem(item);
//            System.out.println("已插入第"+i+"个，主键编号是"+id);
//        }
        return "index";
    }



    @RequestMapping(value = "/type", method = RequestMethod.GET)
    public String type() {
        return "admin/type";
    }

    @RequestMapping("/item/{name}")
    public String item(@PathVariable  String name) {

        System.out.println(itemService.GetItem(name));

        return "admin/item";
    }

    @RequestMapping("/items")
    @ResponseBody
    public String items() {
        Page<Item> pages = itemService.getItems(null, (long)1);

        return "";
    }
}
