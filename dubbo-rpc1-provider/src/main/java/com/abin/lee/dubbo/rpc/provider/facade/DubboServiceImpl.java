package com.abin.lee.dubbo.rpc.provider.facade;

import com.abin.lee.dubbo.rpc.api.DubboService;
import com.abin.lee.dubbo.rpc.enums.UserRole;
import com.abin.lee.dubbo.rpc.model.OrderInfo;
import com.abin.lee.dubbo.rpc.model.UserInfo;
import com.alibaba.dubbo.rpc.RpcContext;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by abin on 2017/9/6 2017/9/6.
 * march-svr
 * com.abin.lee.march.svr.rpc.service.impl
 */
public class DubboServiceImpl implements DubboService {
    private static final Logger logger = LoggerFactory.getLogger(DubboServiceImpl.class);

    public String build(String name) throws Exception {
        String traceId = RpcContext.getContext().getAttachment("traceId");
        logger.info(" got a argument: " + name + ", traceId=..." + traceId);
        logger.error(" got a argument: " + name + ", traceId=..." + traceId);
        logger.debug(" got a argument: " + name + ", traceId=..." + traceId);
        return "message from provider: " + name;
    }

    @Override
    public List<Integer> findById(int id) {
        List<Integer> list = Lists.newArrayList();
        for (int i = 0; i < id; i++) {
            list.add(i);
        }
        return list;
    }

    @Override
    public UserRole findByParam(int id) {
        if (id == 10)
            return UserRole.SYSTEM;
        return UserRole.MANNUAL;
    }


    @Override
    public List<Integer> findById(List<Integer> list) {
        int id = list.get(0);
        List<Integer> result = Lists.newArrayList();
        for (int i = 0; i < id; i++) {
            result.add(i);
        }
        return result;
    }

    @Override
    public List<UserInfo> findUserInfoById(List<Integer> list) {
        int id = list.get(1);
        List<UserInfo> result = Lists.newArrayList();
        for (int i = 0; i < id; i++) {
            result.add(new UserInfo(i, "abin" + i));
        }
        return result;
    }

    @Override
    public List<OrderInfo> findUserInfoById(OrderInfo orderInfo) {
        List<OrderInfo> result = Lists.newArrayList();

        OrderInfo.BasicInfo basicInfo = new OrderInfo.BasicInfo();
        List<BigDecimal> basicPrice = Lists.newArrayList();
        basicPrice.add(new BigDecimal("24.56789"));
        basicPrice.add(new BigDecimal("24.56790"));


        return null;
    }
}
