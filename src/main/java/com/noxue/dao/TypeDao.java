package com.noxue.dao;

import com.noxue.domain.Type;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by noxue on 2017/3/30.
 */
public interface TypeDao extends CrudRepository<Type, Long> {
    public Type findByName(String name);
}