package com.noxue.controller;

import com.noxue.domain.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by noxue on 2017/3/29.
 */
@Controller
@EnableAutoConfiguration
public class AdminItem {

    @RequestMapping("/")
    String home(@RequestParam  String name) {

        return "index";
    }

    @RequestMapping("/item")
    String item() {

        return "admin/item";
    }
}
