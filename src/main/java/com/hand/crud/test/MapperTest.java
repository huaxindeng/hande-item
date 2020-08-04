package com.hand.crud.test;

import com.hand.crud.bean.Item;
import com.hand.crud.dao.ItemMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Author huaxin
 * @Date 2020/7/21
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MapperTest {

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private SqlSession sqlSession;

    @Test
    public void ItemMapperTest(){
//        Item item = itemMapper.selectByPrimaryKey((long) 1);
//        System.out.println(item.toString());
//        item.setItemCode(UUID.randomUUID().toString().substring(0,5));
//        itemMapper.updateByPrimaryKeySelective(item);
//        System.out.println(item.toString());

        ItemMapper itemMapper1 = sqlSession.getMapper(ItemMapper.class);
//
        for(int i=22;i<25;i++){
            Item item1 = new Item(UUID.randomUUID().toString().substring(0,5),"米","无",new Date(),new Date());
//            item1.setItemId((long)i);
//            Item item1 = new Item();
            item1.setItemId((long)i);
            item1.setItemCode("ITEM00"+i);
            itemMapper1.insertBatch(item1);
//            System.out.println(itemMapper1.selectByPrimaryKey((long)i).toString());
        }
    }

    @Test
    public void testSelectBySelection() throws ParseException {
        Item item = new Item();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

//        item.setItemCode("ITEM0071");
        item.setItemDescription("A");
        item.setStartActiveDate(sdf.parse("2020-07-22"));
        List<Item> items = itemMapper.selectBySelection(item);
        System.out.println(items.toString());
    }

    @Test
    public void testInsertSelective() throws ParseException {
        Item item = new Item();
        item.setItemDescription("AAAA");
        item.setItemUom("米");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        item.setStartActiveDate(sdf.parse("2020-07-01"));
        item.setEndActiveDate(sdf.parse("2020-07-010"));
        item.setEnabledFlag(true);
        itemMapper.insertSelective(item);
    }

    @Test
    public void testDeleteByPrimaryKey(){
        itemMapper.deleteByPrimaryKey((long) 57);
    }

    @Test
    public void testDateFormat() throws ParseException {
        Date startActiveDate = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = sdf.format(startActiveDate);
        //2020-07-23
        System.out.println(dateStr);
        Date format = sdf.parse(dateStr);
        //Thu Jul 23 00:00:00 CST 2020
        System.out.println(format.toString());
    }

    @Test
    public void testBooleanOf(){
        System.out.println(new Boolean(Boolean.valueOf("true")));
    }
}
