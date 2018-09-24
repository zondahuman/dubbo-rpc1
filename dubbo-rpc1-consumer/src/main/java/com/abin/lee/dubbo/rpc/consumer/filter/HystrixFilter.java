package com.abin.lee.dubbo.rpc.consumer.filter;

import com.abin.lee.dubbo.rpc.consumer.hystrix.DubboHystrixCommand;
import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.*;

/**
 * Created by abin on 2018/9/23.
 */
@Activate(group = Constants.CONSUMER)
public class HystrixFilter implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        DubboHystrixCommand command = new DubboHystrixCommand(invoker, invocation, "ERROR");
        Result res = command.execute();
        return res;
    }

}