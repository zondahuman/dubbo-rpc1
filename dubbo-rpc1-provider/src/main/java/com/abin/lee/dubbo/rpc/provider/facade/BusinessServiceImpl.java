package com.abin.lee.dubbo.rpc.provider.facade;

import com.abin.lee.dubbo.rpc.api.BusinessService;
import com.abin.lee.dubbo.rpc.common.util.DateUtil;
import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
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


//    @Override
//    public String create(String name) throws Exception {
//        String logSessionIds = RpcContext.getContext().getAttachment("traceId");
//        System.out.println("build--name: " + name + ", traceId="+logSessionIds);
//        return "message from provider: " + name;
//    }

    @Override
    public String createBusiness(String name) throws Exception {
        if (StringUtils.isBlank(name)) {
            throw new RuntimeException("a new exception ..");
        }
        return DateUtil.getYMDHMSTime() + " : " + name;
    }


    @Override
    public String createBusiness(Integer param) throws Exception {
//        Integer result = param + 5;
//        return result + "";
        initFlowRules();
        Entry entry = null;
        try {
            entry = SphU.entry("HelloWorld");
            System.out.println("hello world");

            return "Hello " + param;
        } catch (BlockException e1) {
            System.out.println("exception is " + BlockException.isBlockException(e1));
            System.out.println("block!");
        } finally {
            if (entry != null) {
                entry.exit();
            }
        }
        return "";
    }


    private void initFlowRules() {
        List<FlowRule> rules = new ArrayList<FlowRule>();
        FlowRule rule = new FlowRule();
        rule.setResource("HelloWorld");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // Set limit QPS to 20.
        rule.setCount(5);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }


}
