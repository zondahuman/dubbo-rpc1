package com.abin.lee.dubbo.rpc.provider.filter;

import com.abin.lee.dubbo.rpc.common.util.JsonUtil;
import com.abin.lee.dubbo.rpc.provider.hystrix.DubboHystrixCommand;
import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.*;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by abin on 2018/9/23.
 */
@Activate(group = Constants.PROVIDER)
public class HystrixFilter implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
//        String name = invocation.getInvoker().getInterface().getName();
//        String typeName = invocation.getInvoker().getInterface().getTypeName();
        String path = invocation.getInvoker().getUrl().getPath();
//        System.out.println("path=" + JsonUtil.toJson(path));
        if (StringUtils.equals(path, "com.abin.lee.dubbo.rpc.api.CommonService")) {
            return invoker.invoke(invocation);
        } else {
            DubboHystrixCommand command = new DubboHystrixCommand(invoker, invocation, "ERROR");
            Result res = command.execute();
            return res;
        }
    }

}
