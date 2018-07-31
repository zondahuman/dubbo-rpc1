package com.abin.lee.dubbo.rpc.provider.filter;


import org.apache.dubbo.rpc.*;

/**
 * Created by WANGJINZHAO on 2017/3/29.
 */
public class ProviderRpcLogSessionFilter implements Filter {

    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        String traceId = RpcContext.getContext().getAttachment("traceId");
        System.out.println("ProviderRpcLogSessionFilter accept traceId=" + traceId);
        //服务段处理完了,给客户端回传回去之前他自己传过来的traceId
//        RpcContext.getContext().setAttachment("traceId", traceId);
        return invoker.invoke(invocation);
    }
}
