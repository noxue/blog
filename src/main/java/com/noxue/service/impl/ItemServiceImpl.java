package com.noxue.service.impl;

import com.noxue.dao.ItemDao;
import com.noxue.dao.TypeDao;
import com.noxue.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by noxue on 2017/3/30.
 */
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemDao itemDao;

    @Autowired
    private TypeDao typeDao;


}
