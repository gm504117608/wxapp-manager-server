package com.wxapp.model;

/**
 * @author guonima
 * @create 2017-07-05 10:01
 */
public class ManagerDTO {

    private ManagerDO managerDO;
    private String token;

    public ManagerDO getManagerDO() {
        return managerDO;
    }

    public void setManagerDO(ManagerDO managerDO) {
        this.managerDO = managerDO;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "ManagerDTO{" +
                "managerDO=" + managerDO +
                ", token='" + token + '\'' +
                '}';
    }
}
