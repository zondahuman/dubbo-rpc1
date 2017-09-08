package com.abin.lee.dubbo.rpc.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by abin on 2017/9/7 2017/9/7.
 * march-svr
 * com.abin.lee.march.svr.dubbo.server.view
 */
public class DubboServer {
    public static void main(String[] args) throws Exception {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"classpath*:spring/dubbo-provider.xml"});
        context.start();
        System.out.println("................................................");
        System.out.println(".......Dubbo Server is Running now!..............");
        System.out.println("................................................");
        System.in.read(); // 按任意键退出

    }
}
