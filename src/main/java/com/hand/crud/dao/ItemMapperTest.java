package com.hand.crud.dao;

import com.hand.crud.bean.Item;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ItemMapperTest {

    Long insertTest(Item item);
}
