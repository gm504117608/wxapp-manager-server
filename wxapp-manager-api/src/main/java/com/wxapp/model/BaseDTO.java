package com.wxapp.model;

/**
 * @author guonima
 * @create 2017-08-10 15:17
 */
public class BaseDTO {

    private String token;

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    @Override
    public String toString() {
        return "BaseDTO{" +
                "token='" + token + '\'' +
                '}';
    }
}
