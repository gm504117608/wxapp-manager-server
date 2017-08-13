package com.wxapp.common.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * 系统使用的一些公共配置文件，在启动项目的时候加载配置文件（sysconfig.properties）信息到Environment类中
 * 提供整个项目使用
 */
public class Environment implements Serializable {

    Logger logger = LoggerFactory.getLogger(Environment.class);

}

