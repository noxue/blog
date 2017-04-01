package com.noxue.controller;

import com.noxue.domain.Item;
import com.noxue.domain.Type;
import com.noxue.model.TypeModel;
import com.noxue.model.TypeSub;
import com.noxue.service.ItemService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * Created by noxue on 2017/3/29.
 */
@RequestMapping(value = "/admin")
@Controller
@EnableAutoConfiguration
public class AdminItem {

    @Autowired
    private ItemService itemService;

    @RequestMapping("")
    public String home() {
//        for(long i=1; i<10; i++) {
//            Item item = new Item();
//            item.setTypeId(1L);
//            item.setTitle("title"+i);
//            item.setUrlName("url"+i);
//            item.setContentText("contentText"+i);
//            item.setOrderId(((int) i));
//
//            Long id  = itemService.SaveItem(item);
//            System.out.println("已插入第"+i+"个，主键编号是"+id);
//        }
//

//        for(long i=1; i<10; i++) {
//            Type type = new Type();
//            type.setName("typename"+i);
//            type.setUrlName("url"+i);
//
//
//            if(i<4) {
//                type.setPid(0L);
//            } else if(i<6) {
//                type.setPid(1L);
//            } else {
//                type.setPid(2L);
//            }
//
//            type.setSeoTitle("seotitle"+i);
//            type.setSeoKeywords("keywords"+i);
//            Long id  = itemService.SaveType(type);            System.out.println("已插入第"+i+"个，主键编号是"+id);
//        }
        return "/admin/index";
    }



    @RequestMapping(value = {"/type"}, method = RequestMethod.GET)
    public String type(Model model) {
        List<TypeSub> types = itemService.GetAllTypes();
        model.addAttribute("types", types);
        model.addAttribute("typeModel", null);
        return "admin/type";
    }

    @RequestMapping(value = {"/type/{urlName}"}, method = RequestMethod.GET)
    public String type(@PathVariable String urlName, Model model) {
        Type type = itemService.GetType(urlName);
        List<Type> typs = itemService.GetTypes();

        List<TypeSub> types = itemService.GetAllTypes();
        model.addAttribute("types", types);

        model.addAttribute("type", type);
        return "admin/type";
    }

    @RequestMapping(value = "/type", method = RequestMethod.POST)
    public String doType( @Valid TypeModel typeModel, BindingResult bindingResult, Model model) {


        if(bindingResult.hasErrors()) {
            FieldError f = bindingResult.getFieldError("name");
            model.addAttribute("type", typeModel);
            return "admin/type";
        }

        Type type = new Type();
        BeanUtils.copyProperties(typeModel, type);
        itemService.SaveType(type);

        return "redirect:/admin";
    }

    @RequestMapping(value = "/types", method = RequestMethod.GET)
    public String types(Model model){
        List<TypeSub> types = itemService.GetAllTypes();
        model.addAttribute("types", types);

        return "/admin/typelist";
    }

    @RequestMapping("/item/{name}")
    public String item(@PathVariable  String name) {

        System.out.println(itemService.GetItem(name));

        return "admin/item";
    }

    /**
     * 查看指定分类下的文章
     * @return
     */
    @RequestMapping("/type/{urlName}/items")
    @ResponseBody
    public String items(@PathVariable  String urlName, Model model, @RequestParam  int page) {

        Type type = itemService.GetType(urlName);
        PageRequest pageRequest = new PageRequest(page, 5);
        Page<Item> pages = itemService.getItems(pageRequest, type.getId());

        model.addAttribute("items", pages.getContent());
        model.addAttribute("total", pages.getTotalPages());
        model.addAttribute("page",page);
        return "";
    }
}
