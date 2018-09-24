package com.abin.lee.dubbo.rpc.provider.filter;


import com.abin.lee.dubbo.rpc.provider.limit.TimerLimit;
import org.apache.dubbo.rpc.*;

/**
 *
 */
public class TrafficLimitFilter implements Filter {

    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        boolean flag = TimerLimit.acquired();
        if(flag){
            return invoker.invoke(invocation);
        }
        return invoker.invoke(invocation);
    }
}
