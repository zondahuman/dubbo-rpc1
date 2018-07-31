package com.abin.lee.dubbo.rpc.consumer.filter;


import org.apache.dubbo.rpc.*;

import java.util.UUID;

/**
 * Created by WANGJINZHAO on 2017/3/29.
 */
public class RpcLogSessionFilter implements Filter {

    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        String sessionId=UUID.randomUUID().toString();
        RpcContext.getContext().setAttachment("traceId",sessionId);
        System.out.println("sessionId="+sessionId);
        return invoker.invoke(invocation);
    }

    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString());
    }


}
