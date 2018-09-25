package com.abin.lee.dubbo.rpc.api;

import com.abin.lee.dubbo.rpc.common.util.DateUtil;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by abin on 2017/9/6 2017/9/6.
 * march-svr
 * com.abin.lee.march.svr.rpc.service.impl
 */
public class CommonServiceMock implements CommonService {


//    @Override
//    public String create(String name) throws Exception {
//        String logSessionIds = RpcContext.getContext().getAttachment("traceId");
//        System.out.println("build--name: " + name + ", traceId="+logSessionIds);
//        return "message from provider: " + name;
//    }

    @Override
    public String create(String name) throws Exception {
        if (StringUtils.isBlank(name)) {
            throw new RuntimeException("a new exception ..");
        }
        return DateUtil.getYMDHMSTime() + " : " + name;
    }

    @Override
    public String create(Integer param) throws Exception {
        return null;
    }
}
