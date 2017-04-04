package com.noxue.dao;

import com.noxue.domain.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * Created by noxue on 2017/3/30.
 */
public interface ItemDao extends JpaRepository<Item, Long> {
    public Item getByUrlName(String urlName);
    public Page<Item> findAllByTypeIdOrderByOrderIdAsc(Pageable pageable, Long typeId);
    public List<Item> findAllByTypeIdOrderByOrderIdAsc(Long typeId);
}
