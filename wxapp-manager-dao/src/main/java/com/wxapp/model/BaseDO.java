package com.wxapp.model;

import java.io.Serializable;

/**
 *
 * BaseDO
 * 统一定义id的BaseEntity基类.基类统一定义id的属性名称、数据类型.子类可重载getId()函数.
 */
public abstract class BaseDO implements Serializable{

	private static final long serialVersionUID = 1L;

	/**
	 * 唯一标识id
	 */
	protected Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
