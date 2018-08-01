package com.abin.lee.dubbo.rpc.provider.filter;

import com.alibaba.dubbo.rpc.*;
import org.apache.log4j.MDC;

/**
 * Created by WANGJINZHAO on 2017/3/29.
 */
public class ProviderRpcLogSessionFilter implements Filter {

    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        String traceId = RpcContext.getContext().getAttachment("traceId");
        MDC.put("TRACE_ID", traceId);
        System.out.println("ProviderRpcLogSessionFilter---traceId=" + traceId);
        return invoker.invoke(invocation);
    }
}
