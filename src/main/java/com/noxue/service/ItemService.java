package com.noxue.service;

import com.noxue.domain.Type;
import org.springframework.data.domain.Page;

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

    public Type GetTypeByName(String name);

    /**
     * 获取指定分类的所有下级分类
     * @param parrentTypeId
     * @return
     */
    public List<Type> GetTypes(Long parrentTypeId);

    /**
     * ge
     * @param parrentTypeId
     * @return
     */
    public Page<Type> GetTypesWithPage(Long parrentTypeId);

}
