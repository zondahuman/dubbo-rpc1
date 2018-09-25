package com.abin.lee.dubbo.rpc.api;

/**
 * Created by abin on 2018/9/25.
 */
public interface BusinessService {

    String createBusiness(String name) throws Exception;

    String createNumber(Integer param) throws Exception;



}
