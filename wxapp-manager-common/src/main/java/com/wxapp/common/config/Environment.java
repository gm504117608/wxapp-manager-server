package com.wxapp.common.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.Serializable;

/**
 * 系统使用的一些公共配置文件，在启动项目的时候加载配置文件（sysconfig.properties）信息到Environment类中
 * 提供整个项目使用
 */
public class Environment implements Serializable {

    Log logger = LogFactory.getLog(Environment.class);

}

