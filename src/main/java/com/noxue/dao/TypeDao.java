package com.noxue.dao;

import com.noxue.domain.Type;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by noxue on 2017/3/30.
 */
public interface TypeDao extends CrudRepository<Type, Long> {
    public Type findByUrlName(String name);
    public List<Type> findAllByPid(Long pid);
}
