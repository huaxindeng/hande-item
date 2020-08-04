package com.hand.crud.test;

import com.hand.crud.bean.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ItemMapperTest {

    @Autowired
    private com.hand.crud.dao.ItemMapperTest itemMapperTest;

    @Test
    public void primaryKeyRollback(){
        Item item = new Item();
        item.setItemId((long) 999);
        item.setItemCode("ITEM00"+999);
        item.setItemUom("米");
        item.setItemDescription("test");
        item.setStartActiveDate(new Date());
        item.setEndActiveDate(new Date());
        item.setEnabledFlag(true);
        Long itemId =  itemMapperTest.insertTest(item);

        System.out.println("返回主键"+itemId);
        System.out.println("返回主键"+item.getItemId());
    }
}
