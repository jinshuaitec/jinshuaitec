package com.jinstec;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

/**
 * @author jins
 * @date on 2018/5/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

/*    @Autowired
    private RedisUtil redisUtil;*/

    @Test
    public void redisTest(){
        stringRedisTemplate.opsForValue().set("ceshi","redis");
        System.out.println(stringRedisTemplate.opsForValue().get("ceshi"));

    }

    public void redisObjectTest(){
   /*     User user = new User();
        user.setName("jisn");
        user.setId("121");*/
   /*     redisTemplate.opsForSet().add("id",user);
        User user1 = (User) redisTemplate.opsForValue().get("id");
        System.out.println(user1.getName());*/
    }

    @Test
    public void setTest(){
        Set<String> stringSet = new HashSet<>();
        stringSet.add("靳帅");
        stringSet.add("小王");
       /* redisUtil.addSet("keySet",stringSet);
        Set<Object> setList = redisUtil.getMember("keySet");*/
      /*  for (Object object : setList){
            System.out.println(object.toString());
        }*/
    }

    @Test
    public void hmAll(){
    /*    Map<String,Object> map = new WeakHashMap<>();
        map.put("jinjin","jinshuai");
        map.put("jinjin","xiaoming");
        redisUtil.hmSet("jiji",map);*/
      /*  List<Object> objectMap = redisUtil.hmGetValues("jiji");
        objectMap.forEach(o -> {
            String ss = (String)o;
            System.out.println(ss);
        });*/
    }

    @Test
    public void testHash(){
     /*   Object object = redisUtil.hmGet("123456","111111");
        String string = (String)object;
        System.out.println(string);*/
    }

    @Test
    public void testAtomicLong(){
     /*   int value = redisUtil.increment("111");
        System.out.println(value)*/;
    }

    @Test
    public void listTest(){
       /* List<Object> list = redisUtil.fetchDataList("11");
        list.forEach(o -> {
            String value = (String)o;
            System.out.println(value);
        });
*/
    }



}
