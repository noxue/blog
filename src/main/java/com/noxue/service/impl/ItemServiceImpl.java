package com.noxue.service.impl;

import com.noxue.dao.ItemDao;
import com.noxue.dao.TypeDao;
import com.noxue.domain.Item;
import com.noxue.domain.Type;
import com.noxue.model.TypeModel;
import com.noxue.model.TypeSub;
import com.noxue.service.ItemService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
    public List<Type> GetTypes() {

        return null;
    }

    @Override
    public List<Type> GetTypes(Pageable pageable, Long parrentTypeId) {
        return null;
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
    public Page<Type> GetTypesWithPage(Pageable pageable, Long parrentTypeId) {

        return null;
    }

    @Override
    public Long SaveItem(Item item) {
        return itemDao.save(item).getId();
    }

    @Override
    public Item GetItem(Long itemId) {
        return null;
    }

    @Override
    public Item GetItem(String urlName) {
        return itemDao.getByUrlName(urlName);
    }

    @Override
    public List<Item> GetItems(Long typeId) {
        return null;
    }

    @Override
    public Page<Item> getItems(PageRequest pageRequest, Long typeId) {
        PageRequest request = new PageRequest(1,5);
        return itemDao.findAll(request);
    }


}
