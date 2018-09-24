package com.abin.lee.dubbo.rpc.api;

import com.abin.lee.dubbo.rpc.enums.UserRole;
import com.abin.lee.dubbo.rpc.model.UserInfo;
import java.util.List;

/**
 * Created by abin on 2017/9/6 2017/9/6.
 * march-svr
 * com.abin.lee.march.svr.rpc.service
 */
public interface GlobalService {

    String create(Integer param) throws Exception;

    String build(String name) throws Exception;

    List<Integer> findById(int id);

    UserRole findByParam(int id);

    List<Integer> findById(List<Integer> list);

    List<UserInfo> findUserInfoById(List<Integer> list);

}
