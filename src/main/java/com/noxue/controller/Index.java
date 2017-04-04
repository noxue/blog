package com.noxue.controller;

import com.noxue.domain.Item;
import com.noxue.domain.Type;
import com.noxue.service.ItemService;
import com.noxue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by noxue on 2017/4/2.
 */
@Controller
public class Index {

    @Autowired
    ItemService itemService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("types", itemService.GetAllTypes(false));
        return "pc/index";
    }


    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("admin");
        return "redirect:/";
    }


        @RequestMapping(value = "/login/callback", method = RequestMethod.GET)
    public String callback(@RequestParam  String authkey, HttpServletRequest request) {
        if(userService.Check(authkey)) {
            request.getSession().setAttribute("admin","admin");
            return "redirect:/admin";
        }

        request.getSession().removeAttribute("admin");
        return "redirect:"+userService.GetLoginUrl();
    }



    @RequestMapping(value = "/{urlName}")
    public String type(@PathVariable String urlName, Model model) {

        Type type = itemService.GetType(urlName);
        List<Item> items = itemService.GetItems(null, type.getId()).getContent();

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

    @RequestMapping(value = "/upload/images/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> loadImg(@PathVariable  String filename) {

        Resource file = itemService.GetAttach(filename);
        return ResponseEntity
                .ok()
                .body(file);
    }
}
