package com.jinstec.core.redis;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * @author jins
 * @date on 2018/5/7.
 */
@Service
public class RedisUtil {

    protected final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 写入缓存
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key,Object value){
        boolean result = false;
        try{
            ValueOperations<String,Object> operations = redisTemplate.opsForValue();
            operations.set(key,value);
            result = true;
        }catch (Exception e){
            logger.info("添加key和value值失败:{}"+e.getMessage());
        }
        return result;
    }

    /**
     * 添加过期时间
     * @param key
     * @param value
     * @param expiredTime
     * @return
     */
    public boolean set(final String key,Object value,Long expiredTime){
        boolean result = false;
        try{
            ValueOperations<String,Object> operations = redisTemplate.opsForValue();
            operations.set(key,value);
            redisTemplate.expire(key,expiredTime, TimeUnit.SECONDS);
            result = true;
        }catch (Exception e){
            logger.info(e.getMessage());
        }
        return result;
    }

    /**
     * 移除key
     * @param key
     */
    public void remove(final String key){
        if (exist(key)){
            redisTemplate.delete(key);
        }
    }

    /**
     * 判断是否存在key
     * @param key
     * @return
     */
    public boolean exist(final String key){
        return redisTemplate.hasKey(key);
    }

    /**
     * 根据key获取值
     * @param key
     * @return
     */
    public Object get(final String key){
        ValueOperations<String,Object> operations = redisTemplate.opsForValue();
        Object object = operations.get(key);
        return object;
    }

    /**
     * 添加到集合
     * @param key
     * @param value
     */
    public void addSet(String key,Object value){
        SetOperations<String,Object> operations = redisTemplate.opsForSet();
        operations.add(key,value);
    }

    /**
     * 得到集合中数据
     * @param key
     * @return
     */
    public Set<Object> getMember( String key){
        SetOperations<String,Object> operations = redisTemplate.opsForSet();
        return operations.members(key);
    }


    /**
     *给key添加新值
     * @param key
     * @param num
     */
    public void setIncrement(String key,int num){
        RedisAtomicLong redisAtomicLong = new RedisAtomicLong(key,redisTemplate.getConnectionFactory());
        redisAtomicLong.set(num);
    }

    /**
     * redis 原子自增
     * @param key
     * @return
     */
    public Integer increment(String key){
        RedisAtomicLong count = new RedisAtomicLong(key,redisTemplate.getConnectionFactory());
        Long increment = count.getAndIncrement();
        return increment.intValue();
    }

    /**
     * 添加hash
     * @param key
     * @param hashKey
     * @param value
     * @return
     */
    public void hmSet(String key,Object hashKey,Object value){
        HashOperations<String,Object,Object> hashOperations = redisTemplate.opsForHash();
        hashOperations.put(key,hashKey,value);
    }

    /**
     * 根据key值和hashKey获取值
     * @param key
     * @param hashKey
     * @return
     */
    public Object hmGet(String key, Object hashKey){
        HashOperations<String,Object,Object> hash = redisTemplate.opsForHash();
        return hash.get(key,hashKey);
    }

    /**
     * 批量添加hash值
     * @param key
     * @param map
     */
    public void hmSet(String key, Map<String,Object> map){
        HashOperations<String,Object,Object> hash = redisTemplate.opsForHash();
        hash.putAll(key,map);
    }

    /**
     * 得到批量化添加的值
     * @param key
     * @return
     */
    public List<Object> hmGetValues(String key){
        HashOperations<String,Object,Object> hash = redisTemplate.opsForHash();
        return hash.values(key);
    }

    /**
     * 往链表里面添加数据
     * @param key
     * @param value
     * @return
     */
    public void push(String key,Object value){
        ListOperations<String,Object> operations = redisTemplate.opsForList();
        operations.leftPush(key,value);
    }

    /**
     * 从list中删除数据
     * @param key
     */
    public Object pop(String key){
        ListOperations<String,Object> operations = redisTemplate.opsForList();
        return operations.rightPop(key);
    }

    /**
     * 从集合里面取出范围集合
     * @param key
     * @return
     */
    public List<Object> fetchDataList(String key){
        ListOperations<String,Object> operations = redisTemplate.opsForList();
        return operations.range(key,0,11);
    }


}
