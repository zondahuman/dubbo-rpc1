package com.abin.lee.dubbo.rpc.provider.facade;

import com.abin.lee.dubbo.rpc.api.BusinessService;
import com.abin.lee.dubbo.rpc.common.util.DateUtil;
import com.abin.lee.dubbo.rpc.provider.exception.ExceptionUtil;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.google.common.primitives.Ints;
import org.springframework.stereotype.Service;

/**
 * Created by abin on 2017/9/6 2017/9/6.
 * march-svr
 * com.abin.lee.march.svr.rpc.service.impl
 * https://github.com/alibaba/Sentinel/wiki/%E6%B3%A8%E8%A7%A3%E6%94%AF%E6%8C%81
 */
@Service(value = "businessService")
public class BusinessServiceImpl implements BusinessService {

    @Override
    @SentinelResource(value = "createBusiness", blockHandler = "handleException", blockHandlerClass = {ExceptionUtil.class})
    public String createBusiness(String input) throws ExceptionUtil {
        Integer param = Ints.tryParse(input);
        if(param % 5 != 4){
            throw new ExceptionUtil("a new exception ..");
        }
        return DateUtil.getYMDHMSTime() + " :createBusiness= " + param;
    }


    @Override
    @SentinelResource(value = "createNumber", blockHandler = "exceptionHandler", fallback = "createFallback")
    public String createNumber(Integer param) throws Exception {
        if(param % 5 != 4){
            throw new RuntimeException("a new exception ..");
        }
        return DateUtil.getYMDHMSTime() + " :createNumber= " + param;
    }

    // Fallback 函数，函数签名与原函数一致.
    public String createFallback(Integer param) {
        return String.format("fallback %d", param);
    }

    // Block 异常处理函数，参数最后多一个 BlockException，其余与原函数一致.
    public String exceptionHandler(Integer param, BlockException ex) {
        // Do some log here.
        ex.printStackTrace();
        return "Oops, error occurred at " + param;
    }

}
