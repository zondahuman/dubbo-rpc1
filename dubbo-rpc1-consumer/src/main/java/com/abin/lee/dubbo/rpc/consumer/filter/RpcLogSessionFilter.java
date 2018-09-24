package com.abin.lee.dubbo.rpc.consumer.filter;


import com.alibaba.dubbo.rpc.*;
import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

/**
 *
 */
public class RpcLogSessionFilter implements Filter {

    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        String sessionId = UUID.randomUUID().toString();
        String traceId = RpcContext.getContext().getAttachment("traceId");
//        String traceId = TraceIdUtil.getTraceId();
        if (StringUtils.isNotBlank(traceId)) {
//            System.out.println("accept traceId=" + traceId);
        } else {
            traceId = sessionId ;
//            System.out.println("create traceId=" + traceId);
        }
        RpcContext.getContext().setAttachment("traceId", traceId);
//        System.out.println("transfer traceId=" + traceId);
        return invoker.invoke(invocation);
    }

    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString());
    }


}
