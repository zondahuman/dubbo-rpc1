package com.abin.lee.dubbo.rpc.provider.facade;

import com.abin.lee.dubbo.rpc.api.BusinessService;
import com.abin.lee.dubbo.rpc.common.util.DateUtil;
import com.abin.lee.dubbo.rpc.provider.exception.ExceptionUtil;
import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.google.common.primitives.Ints;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abin on 2017/9/6 2017/9/6.
 * march-svr
 * com.abin.lee.march.svr.rpc.service.impl
 */
@Service(value = "businessService")
public class BusinessServiceImpl implements BusinessService {

    @Override
    @SentinelResource(value = "createBusiness", blockHandler = "handleException", blockHandlerClass = {ExceptionUtil.class})
    public String createBusiness(String input) throws Exception {
        Integer param = Ints.tryParse(input);
        if(param != 0){
            throw new RuntimeException("a new exception ..");
        }
        return DateUtil.getYMDHMSTime()+" :createBusiness= " + param;
    }


    @Override
    @SentinelResource(value = "createNumber", blockHandler = "exceptionHandler", fallback = "createFallback")
    public String createNumber(Integer param) throws Exception {
        if(param != 0){
            throw new RuntimeException("a new exception ..");
        }
        return DateUtil.getYMDHMSTime()+" :createNumber= " + param;
    }

    // Fallback 函数，函数签名与原函数一致.
    public String createFallback(long s) {
        return String.format("fallback %d", s);
    }

    // Block 异常处理函数，参数最后多一个 BlockException，其余与原函数一致.
    public String exceptionHandler(long s, BlockException ex) {
        // Do some log here.
        ex.printStackTrace();
        return "Oops, error occurred at " + s;
    }

}
