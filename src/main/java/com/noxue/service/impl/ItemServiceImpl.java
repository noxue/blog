package com.noxue.service.impl;

import com.noxue.dao.ItemDao;
import com.noxue.dao.TypeDao;
import com.noxue.domain.Item;
import com.noxue.domain.Type;
import com.noxue.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
    public List<Type> GetTypes(Pageable pageable, Long parrentTypeId) {
        return null;
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
