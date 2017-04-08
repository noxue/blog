package com.noxue.controller;

import com.noxue.domain.Item;
import com.noxue.domain.Type;
import com.noxue.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by noxue on 2017/4/8.
 */
@Controller
public class Encode {
    @Autowired
    ItemService itemService;
    @RequestMapping(value = "/type/html/{urlName}")
    public String typeHtml(@PathVariable String urlName, Model model) {

        Type type = itemService.GetType(urlName);

        model.addAttribute("html", type.getContentText());

        return "pc/html";
    }


    @RequestMapping(value = "/item/html/{itemUrl}", method = RequestMethod.GET)
    public String itemHtml(Model model,  @PathVariable String itemUrl) {

        Item item = itemService.GetItem(itemUrl);
        model.addAttribute("html", item.getContentText());
        return "pc/html";
    }

}
