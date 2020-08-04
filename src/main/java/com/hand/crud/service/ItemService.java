package com.hand.crud.service;

import com.hand.crud.bean.Item;
import com.hand.crud.bean.ItemExample;
import com.hand.crud.dao.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author huaxin
 * @Date 2020/7/21
 */
@Service
@Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
public class ItemService {

    @Autowired
    private ItemMapper itemMapper;

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Item> getAll(){
        return itemMapper.selectByExample(null);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Item> getBySelection(Item item) {
        return itemMapper.selectBySelection(item);
    }

    public int saveItem(Item item){
        return itemMapper.insertSelective(item);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Item getById(Long id){
        return itemMapper.selectByPrimaryKey(id);
    }

    @Transactional(readOnly = false,propagation = Propagation.REQUIRED)
    public int updateItem(Item item){
        return itemMapper.updateByPrimaryKeySelective(item);
    }

    @Transactional(readOnly = false,propagation = Propagation.REQUIRED)
    public int deleteItem(Long itemId){
        return itemMapper.deleteByPrimaryKey(itemId);
    }

    @Transactional(readOnly = false,propagation = Propagation.REQUIRED)
    public void deleteBatch(List<Long> ids) {
        // TODO Auto-generated method stub
        ItemExample example = new ItemExample();
        ItemExample.Criteria criteria = example.createCriteria();
        //delete from xxx where emp_id in(1,2,3)
        criteria.andItemIdIn(ids);
        itemMapper.deleteByExample(example);
    }
}
