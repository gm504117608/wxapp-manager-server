package com.wxapp.mapper;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * BaseMapper
 * 基础mapper定义,可以自己重写，也可加入自己的方法
 *
 * @param <T>  操作的对象类型
 * @param <ID> id
 */
public interface BaseMapper<T, ID extends Serializable> {

    public int insert(T t);

    public int insertBatch(List<T> t);

    public int update(T t);

    public int deleteBatchById(List<ID> ids);

    public int deleteById(ID id);

    public int deleteById(String id);

    public T find(Map<String, Object> parameter);

    public T find(T t);

    public T findById(ID id);

    public T findById(String id);

    public List<T> queryListAll(Map<String, Object> parameter);

    public List<T> queryListAll(T t);

    public List<T> queryListByPage(Map<String, Object> parameter);

    public int count(Map<String, Object> parameter);

    public int count(T t);

}
