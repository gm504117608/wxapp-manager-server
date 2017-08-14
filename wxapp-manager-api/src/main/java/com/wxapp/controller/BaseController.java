package com.wxapp.controller;

import com.wxapp.service.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author guonima
 * @create 2017-04-12 13:24
 */
public class BaseController {

    Logger logger = LoggerFactory.getLogger(BaseController.class);

    /**
     * 操作成功
     *
     * @param obj 返回数据
     * @return
     */
    public Response success(Object obj) {
        Response r = new Response();
        r.setCode(0);
        r.setMessage("操作成功");
        r.setData(obj);
        return r;
    }

    /**
     * 操作成功
     *
     * @param message 提示信息
     * @param obj     返回数据
     * @return
     */
    public Response success(String message, Object obj) {
        Response r = new Response();
        r.setCode(0);
        r.setMessage(message);
        r.setData(obj);
        return r;
    }

    /**
     * 操作失败
     *
     * @param code    错误代码
     * @param message 错误提示信息
     * @return
     */
    public Response error(int code, String message) {
        Response r = new Response();
        r.setCode(code);
        r.setMessage(message);
        return r;
    }

    /**
     * 操作失败
     *
     * @param code    错误代码
     * @param message 错误提示信息
     * @param obj     返回数据
     * @return
     */
    public Response error(int code, String message, Object obj) {
        Response r = new Response();
        r.setCode(code);
        r.setMessage(message);
        r.setData(obj);
        return r;
    }


    /**
     * controller 端异常处理， 拦截报出来的异常信息，并做处理
     *
     * @param e 异常
     * @return
     */
    @ExceptionHandler
    public Object handlerException(Exception e) {
        logger.error("亲，出现了未知错误，请使用用户反馈功能投诉死他们。" + e.getMessage());
        e.printStackTrace();

        Response r = new Response();
        r.setCode(9999);
        r.setMessage("亲，出现了未知错误，请使用用户反馈功能投诉死他们。");
        return r;
    }

}
