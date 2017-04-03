package com.noxue.service.impl;

import com.noxue.dao.AttachDao;
import com.noxue.dao.ItemDao;
import com.noxue.dao.TypeDao;
import com.noxue.domain.Attach;
import com.noxue.domain.Item;
import com.noxue.domain.Type;
import com.noxue.model.TypeModel;
import com.noxue.model.TypeSub;
import com.noxue.service.ItemService;
import javassist.bytecode.stackmap.TypeData;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by noxue on 2017/3/30.
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemDao itemDao;

    @Autowired
    private TypeDao typeDao;

    @Autowired
    private AttachDao attachDao;

    @Value("${upload.root}")
    private String UPLOAD_ROOT;

    @Override
    public Long SaveType(Type type) {

        return typeDao.save(type).getId();
    }

    @Override
    public Type GetType(Long typeId) {
        return typeDao.findOne(typeId);
    }

    @Override
    public Type GetType(String urlName) {
        return typeDao.findByUrlName(urlName);
    }




    @Override
    public List<TypeSub> GetAllTypes() {

        List<TypeSub> tss = new ArrayList<TypeSub>();

        for(Type t : typeDao.findAllByPid(0L)) {
            TypeSub ts = new TypeSub();
            ts.setType(t);

            //获取子菜单,如果有子目录，就添加
            for(Type tt:typeDao.findAllByPid(t.getId())) {
                TypeSub tsb = new TypeSub();
                tsb.setType(tt);
                ts.getSubs().add(tsb);
            }

            tss.add(ts);
        }

        return tss;
    }

    @Override
    public Long SaveItem(Item item) {
        return itemDao.save(item).getId();
    }

    @Override
    public Item GetItem(Long itemId) {
        return itemDao.findOne(itemId);
    }

    @Override
    public Item GetItem(String urlName) {
        return itemDao.getByUrlName(urlName);
    }


    @Override
    public Page<Item> GetItems(PageRequest pageRequest, Long typeId) {

        return itemDao.findAllByTypeIdOrderByOrderIdAsc(pageRequest, typeId);
    }

    @Override
    public void DeleteItem(Long id) {
        itemDao.delete(id);
    }

    @Override
    public Long SaveAttach(Attach attach) {
        return attachDao.save(attach).getId();
    }

    @Override
    public Resource GetAttach(String name) {

        //防止用户利用上级目录跳出当前目录
        if(name.contains("..")) {
            return null;
        }

        String fileName = new File(UPLOAD_ROOT).getAbsolutePath()+File.separator
                + name.replace("-",File.separator);

      //  fileName = fileName.replace("\\", "\\\\");

        if(!new File(fileName).exists()) {
            return null;
        }

        try {
            Resource resource = new UrlResource("file",fileName);
            if(resource.exists() || resource.isReadable()) {
                return resource;
            }
            else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
