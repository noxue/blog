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

import java.util.List;

/**
 * Created by noxue on 2017/4/2.
 */
@Controller
public class Index {

    @Autowired
    ItemService itemService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("types", itemService.GetAllTypes());

        return "pc/index";
    }

    @RequestMapping(value = "/{urlName}")
    public String type(@PathVariable String urlName, Model model) {

        Type type = itemService.GetType(urlName);
        List<Item> items = itemService.getItems(null, type.getId()).getContent();

        model.addAttribute("type", type);
        model.addAttribute("items", items);

        return "pc/type";
    }

    @RequestMapping(value = "/{typeUrl}/{itemUrl}.html", method = RequestMethod.GET)
    public String item(Model model, @PathVariable  String typeUrl, @PathVariable String itemUrl) {

        Type type = itemService.GetType(typeUrl);
        Item item = itemService.GetItem(itemUrl);

        model.addAttribute("type", type);
        model.addAttribute("item", item);

        return "pc/item";
    }
}
