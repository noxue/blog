package com.noxue.service;

import com.noxue.domain.Item;
import com.noxue.domain.Type;
import com.noxue.model.TypeSub;
import org.hibernate.validator.internal.xml.GetterType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by noxue on 2017/3/30.
 */
public interface ItemService {
    /**
     * 添加或修改分类
     * @param type 如果有id就是修改
     * @return
     */
    public Long SaveType(Type type);

    public Type GetType(Long typeId);
    public Type GetType(String urlName);

    public List<Type> GetTypes();

    /**
     * 获取指定分类的所有下级分类
     * @param parrentTypeId
     * @return
     */
    public List<Type> GetTypes(Pageable pageable,Long parrentTypeId);

    public List<TypeSub> GetAllTypes();
    /**
     * ge
     * @param parrentTypeId
     * @return
     */
    public Page<Type> GetTypesWithPage(Pageable pageable,Long parrentTypeId);

    ///=======================================================================================
    public Long SaveItem(Item item);

    public Item GetItem(Long itemId);

    public Item GetItem(String urlName);

    public List<Item> GetItems(Long typeId);

    public Page<Item> getItems(PageRequest pageRequest, Long typeId);
}
