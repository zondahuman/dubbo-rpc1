package com.abin.lee.dubbo.rpc.consumer;

import com.abin.lee.dubbo.rpc.api.DubboService;
import com.abin.lee.dubbo.rpc.api.GlobalService;
import com.abin.lee.dubbo.rpc.common.util.JsonUtil;
import com.abin.lee.dubbo.rpc.enums.UserRole;
import com.abin.lee.dubbo.rpc.model.UserInfo;
import com.google.common.collect.Lists;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

/**
 * Created by abin on 2017/9/7 2017/9/7.
 * march-svr
 * com.abin.lee.march.svr.dubbo.client.view
 */
public class DubboClientServer {


    public static void main(String[] args) throws InterruptedException {
        //synchronous
//        main_sync();
        //asynchronous
//        main_async();
        //traceId
        main_filter();
    }

    public static void main_sync() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath*:spring/dubbo-consumer.xml"});
        context.start();
        DubboService dubboService = (DubboService) context.getBean("dubboService"); // 获取bean
        // service
        // invocation
        // proxy
        String message = "";
        List<Integer> list = null;
        UserRole userRole = UserRole.DEFAULT;
        List<Integer> resultList = null;
        List<UserInfo> userInfoList = null;
        try {
            message = dubboService.build("2016-10-20");
            System.out.println(" the message from server is:" + message);
            list = dubboService.findById(5);
            System.out.println("list is:" + JsonUtil.toJson(list));
            userRole = dubboService.findByParam(10);
            System.out.println("userRole is:" + userRole);
            resultList = dubboService.findById(Lists.newArrayList(1, 2));
            System.out.println("resultList is:" + JsonUtil.toJson(resultList));
            userInfoList = dubboService.findUserInfoById(Lists.newArrayList(1, 2));
            System.out.println("userInfoList is:" + JsonUtil.toJson(userInfoList));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main_async() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath*:spring/dubbo-consumer.xml"});
        context.start();
        GlobalService globalService = (GlobalService) context.getBean("globalService"); // 获取bean
        UserRole userRole = UserRole.DEFAULT;
        try {
            userRole = globalService.findByParam(10);
            System.out.println("userRole is:" + userRole);

            Future<UserRole> pFuture = RpcContext.getContext().getFuture();
            //如果Person已返回，直接拿到返回值，否则线程wait，等待Person返回后，线程会被notify唤醒。
            userRole = pFuture.get();
            System.out.println("userRole Async is:" + userRole);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void main_filter() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath*:spring/dubbo-consumer.xml"});
        context.start();
        DubboService dubboService = (DubboService) context.getBean("dubboService"); // 获取bean
        String message = "";

        try {
            Map<String, String> param = new HashMap<>();
            int randomTraceId = (int) (Math.random() * 1000);
            param.put("traceId", randomTraceId + "");
            RpcContext.getContext().setAttachments(param);
            message = dubboService.build("2016-10-20");
            System.out.println("dubboService.build-- the message from server is:" + message);
            List<Integer> list = dubboService.findById(5);
            System.out.println("dubboService.findById--- the message from server is:" + JsonUtil.toJson(list));
            String traceId = RpcContext.getContext().getAttachment("traceId");
            System.out.println(" the message from server is result traceId :" + traceId);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
