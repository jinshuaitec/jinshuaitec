package com.jinstec.dao;

import java.util.List;
import java.util.Map;

/**
 * baseDao
 * Created by xuew on 2018/1/5.
 */
public interface BaseMapper<T> {

    /**
     * 插入一条记录
     * @param record 记录
     * @return 成功数
     */
    int insert(T record);

    /**
     * 插入一条记录(非null属性)
     * @param record 记录
     * @return 成功数
     */
    int insertSelective(T record);

    /**
     * 根据主键查找记录
     * @param id 主键
     * @return 记录
     */
    T selectByPrimaryKey(String id);

    /**
     * 根据主键更新对象
     * @param record 更新的对象
     * @return 成功条数 注意如果用到乐观锁请主动判断条数
     */
    int updateByPrimaryKey(T record);

    /**
     * 根据id删除记录
     * @param id 主键
     * @return 成功数
     */
    int deleteByPrimaryKey(String id);

    /**
     * 根据主键更新对象
     * @param record 更新的对象
     * @return 成功条数 注意如果用到乐观锁请主动判断条数
     */
    int updateByPrimaryKeySelective(T record);

    /**
     * 批量插入(默认MBG不生成此方法，如果需要调用请在XML中编写,否则程序将出现异常)
     * @param record 记录
     * @return 成功数
     */
    int insertBatch(List<T> record);

    /**
     * 批量更新(默认MBG不生成此方法，如果需要调用请在XML中编写,否则程序将出现异常)
     * @param record 更新的对象集合
     * @return 成功条数
     */
    int updateByPrimaryKeyBatch(List<T> record);

    /**
     * 批量根据id删除记录(默认MBG不生成此方法，如果需要调用请在XML中编写,否则程序将出现异常)
     * @param id 主键集合
     * @return 成功数
     */
    int deleteByPrimaryKeyBatch(List<String> id);

    /**
     * 通用分页方法(默认MBG不生成此方法，如果需要调用请在XML中编写,否则程序将出现异常)
     * @param condition 条件
     * @return 分页结果集合
     */
    List findAll(Map<String, Object> condition);

    /**
     * 批量更新
     * @param list
     * @return
     */
    int updateBatch(List<T> list);
}
