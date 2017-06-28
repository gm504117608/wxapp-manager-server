package com.wxapp.service.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * BaseService  service层接口
 *
 * @param <T>
 * @param <ID>
 */
public interface BaseService<T, ID extends Serializable> {

    /**
     * @param t 插入的对象
     * 
     * @return int    返回影响的行数
     */
    public int insert(T t);

    /**
     * @param t 插入的对象
     * 
     * @return int    返回影响的行数
     */
    public int insertBatch(List<T> t);

    /**
     * @param ids 删除的id
     * 
     * @return int    返回影响的行数
     */
    public int deleteBatchById(List<ID> ids);

    /**
     * @param id id
     * 
     * @return int    返回影响的行数
     */
    public int deleteById(ID id);

    /**
     * @param id id
     * 
     * @return int    返回影响的行数
     */
    public int deleteById(String id);

    /**
     * @param t 更新的对象
     * 
     * @return int    返回影响的行数
     */
    public int update(T t);

    /**
     * @param parameter 查询参数map
     * 
     * @return T    返回查询的对象
     */
    public T find(Map<String, Object> parameter);

    /**
     * @param t 查询参数对象
     * 
     * @return T    返回查询的对象
     */
    public T find(T t);

    /**
     * @param id id
     * 
     * @return T    返回查询的对象
     */
    public T findById(ID id);

    /**
     * @param id id
     * 
     * @return T    返回查询的对象
     */
    public T findById(String id);

    /**
     * @param parameter 查询参数map
     * 
     * @Description: 根据参数查询全部对象
     * @return List<T>	返回查询的对象集合
     */
    public List<T> queryListAll(Map<String, Object> parameter);

    /**
     * @param t 查询参数对象
     * 
     * @return List<T>	返回查询的对象集合t
     */
    public List<T> queryListAll(T t);

    /**
     * @param parameter 查询参数map
     * 
     * @return List<T>	返回查询的对象集合
     */
    public List<T> queryListByPage(Map<String, Object> parameter);

    /**
     * @param parameter 查询参数map
     * 
     * @return int    返回查询的对象总条数
     */
    int count(Map<String, Object> parameter);

    /**
     * @param t 查询参数对象
     * 
     * @return int    返回查询的对象总条数
     */
    int count(T t);

}
