package com.hand.crud.dao;

import com.hand.crud.bean.Item;
import com.hand.crud.bean.ItemExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ItemMapper {
    long countByExample(ItemExample example);

    int deleteByExample(ItemExample example);

    int deleteByPrimaryKey(Long itemId);

    int insert(Item record);

    int insertSelective(Item record);

    int insertBatch(Item record);

    List<Item> selectByExample(ItemExample example);

    List<Item> selectBySelection(Item item);

    Item selectByPrimaryKey(Long itemId);

    int updateByExampleSelective(@Param("record") Item record, @Param("example") ItemExample example);

    int updateByExample(@Param("record") Item record, @Param("example") ItemExample example);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKey(Item record);
}