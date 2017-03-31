package com.noxue.dao;

import com.noxue.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by noxue on 2017/3/30.
 */
public interface ItemDao extends JpaRepository<Item, Long> {
    public Item getByUrlName(String urlName);
}
