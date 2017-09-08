package com.abin.lee.dubbo.rpc.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by abin on 2017/9/7 13:52.
 * march-svr
 * com.abin.lee.march.svr.dubbo.model
 */
@Getter
@Setter
@ToString
public class UserInfo implements Serializable {

    private Integer id;
    private String userName;

    public UserInfo() {
    }

    public UserInfo(Integer id, String userName) {
        this.id = id;
        this.userName = userName;
    }

}
