package com.noxue.controller;

import com.noxue.domain.Attach;
import com.noxue.domain.Item;
import com.noxue.domain.Type;
import com.noxue.model.ItemModel;
import com.noxue.model.TypeModel;
import com.noxue.model.TypeSub;
import com.noxue.model.UpImgModel;
import com.noxue.service.ItemService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by noxue on 2017/3/29.
 */
@RequestMapping(value = "/admin")
@Controller
@EnableAutoConfiguration
public class AdminItem {

    @Autowired
    private ItemService itemService;

    @Value("${upload.root}")
    private String UPLOAD_ROOT;

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
//
//        for(long i=1; i<10; i++) {
//            Type type = new Type();
//            type.setName("typename"+i);
//            type.setUrlName("url"+i);
//            type.setContentText("# asdfasfasfasdfadf\n~~asfadf~~"+i+i+i+i);
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

    @RequestMapping(value = "/upimage", method = RequestMethod.POST)
    public @ResponseBody UpImgModel fileUpload2(@RequestParam("editormd-image-file") MultipartFile file) throws IOException {

        //记录上传是否成功，1表示成功
        int status = 1;
        String message = "";

        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy"+File.separator+"MM"+File.separator+"dd");
        String dateNowStr = sdf.format(d);

        String rootPath = new File(UPLOAD_ROOT).getAbsolutePath();

        // 年月日+UUID去掉横线之后的字符串+原文件名后缀
        String fileName = File.separator
                +dateNowStr
                + File.separator
                + "noxue_com_"
                + UUID.randomUUID().toString().replace("-","")
                +file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));

        // 如果目录不存在，那么就创建目录
        File f = new File(rootPath+File.separator+dateNowStr);
        if(!f.exists()) {
            if(!f.mkdirs()) {
                status=0; // 创建文件失败，也就不会上传成功了。
                message = "创建目录失败";
            }
        }

        try{

            File newFile=new File(rootPath+fileName);
            //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
            file.transferTo(newFile);

            status=1;
        } catch (Exception e) {
            status=0;
            message="文件上传失败";
        }



         /*
             上传的后台只需要返回一个 JSON 数据，结构如下：
             {
             success : 0 | 1,           // 0 表示上传失败，1 表示上传成功
             message : "提示的信息，上传成功或上传失败及错误信息等。",
             url     : "图片地址"        // 上传成功时才返回
             }
             */

        //把路径分隔符替换成 -  用于获取文件的时候方便取参数，如果是 /  那么不方便处理。
        fileName = fileName.replace(File.separator, "-").substring(1);


        //如果文件上传成功，那么保存到数据库。
        if(status==1) {
            itemService.SaveAttach(new Attach(fileName,file.getContentType(),false));
        }


        return new UpImgModel(status,"msg", "/upload/images/"+fileName);
    }

    @RequestMapping(value = {"/type/{urlName}"}, method = RequestMethod.GET)
    public String type(@PathVariable String urlName, Model model) {
        Type type = itemService.GetType(urlName);

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

            List<TypeSub> types = itemService.GetAllTypes();
            model.addAttribute("types", types);

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



    @RequestMapping(value = "/item", method = RequestMethod.GET)
    public String item(Model model) {
        List<TypeSub> types = itemService.GetAllTypes();
        model.addAttribute("types", types);
        return "admin/item";
    }


    @RequestMapping(value = "/item", method = RequestMethod.POST)
    public String item(@Valid ItemModel itemModel, BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()){
            List<TypeSub> types = itemService.GetAllTypes();
            model.addAttribute("types", types);
            model.addAttribute("item", itemModel);
            return "admin/item";
        }

        Item item = new Item();

        BeanUtils.copyProperties(itemModel, item);

        itemService.SaveItem(item);

        Type type = itemService.GetType(item.getTypeId());

        return "redirect:/admin/type/"+type.getUrlName()+"/items";
    }



    @RequestMapping("/item/{name}")
    public String item(@PathVariable  String name, Model model) {

        Item item = itemService.GetItem(name);
        Type type = itemService.GetType(item.getTypeId());

        List<TypeSub> types = itemService.GetAllTypes();
        model.addAttribute("types", types);

        model.addAttribute("item", item);
        model.addAttribute("type", type);

        return "admin/item";
    }

    /**
     * 查看指定分类下的文章
     * @return
     */
    @RequestMapping("/type/{urlName}/items")
    public String items(@PathVariable  String urlName, Model model, @RequestParam(defaultValue = "1")  int page) {

        Type type = itemService.GetType(urlName);
        PageRequest pageRequest = new PageRequest(page-1, 10);
        Page<Item> pages = itemService.GetItems(pageRequest, type.getId());

        model.addAttribute("type", type);
        model.addAttribute("items", pages.getContent());
        model.addAttribute("total", pages.getTotalPages());
        model.addAttribute("page",page);
        return "/admin/itemlist";
    }

    @RequestMapping(value = "/item/{id}/delete")
    public String itemDelete(@PathVariable long id) {

        Item item = itemService.GetItem(id);
        if(item != null) {
            long typeId = item.getTypeId();
            Type type = itemService.GetType(typeId);
            if(type !=null) {
                itemService.DeleteItem(id);
                return "redirect:/admin/type/"+type.getUrlName()+"/items";
            }
        }

        return "redirect:/admin/types";
    }
}
