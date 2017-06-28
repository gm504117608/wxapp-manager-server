package com.wxapp.service.base.impl;


import com.wxapp.exception.ServiceException;
import com.wxapp.mapper.BaseMapper;
import com.wxapp.service.base.BaseService;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * AbstractService
 * service层基类
 *
 * @param <T>  操作对象类型
 * @param <ID> id
 */
public class AbstractService<T, ID extends Serializable> implements BaseService<T, ID> {

    private BaseMapper<T, ID> baseMapper;

    public void setBaseMapper(BaseMapper<T, ID> baseMapper) {
        this.baseMapper = baseMapper;
    }

    public int insert(T t) {
        try {
            return baseMapper.insert(t);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    public int insertBatch(List<T> t) {
        try {
            return baseMapper.insertBatch(t);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    public int deleteById(ID id) {
        try {
            return baseMapper.deleteById(id);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    public int deleteById(String id) {
        try {
            return baseMapper.deleteById(id);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    public int update(T t) {
        try {
            return baseMapper.update(t);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    public int deleteBatchById(List<ID> ids) {
        try {
            return baseMapper.deleteBatchById(ids);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    public T find(Map<String, Object> parameter) {
        return baseMapper.find(parameter);
    }

    public T find(T t) {
        return baseMapper.find(t);
    }

    public T findById(ID id) {
        return baseMapper.findById(id);
    }

    public T findById(String id) {
        return baseMapper.findById(id);
    }

    public List<T> queryListAll(Map<String, Object> parameter) {
        return baseMapper.queryListAll(parameter);
    }

    public List<T> queryListAll(T t) {
        return baseMapper.queryListAll(t);
    }

    public List<T> queryListByPage(Map<String, Object> parameter) {
        return baseMapper.queryListByPage(parameter);
    }

    public int count(Map<String, Object> parameter) {
        return baseMapper.count(parameter);
    }

    public int count(T t) {
        return baseMapper.count(t);
    }


}
