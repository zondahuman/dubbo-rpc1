package com.abin.lee.dubbo.rpc.provider.limit;

import com.abin.lee.dubbo.rpc.common.util.DateUtil;
import com.google.common.util.concurrent.RateLimiter;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by abin on 2018/9/20.
 */
public class TimerLimit {
    static RateLimiter limiter = RateLimiter.create(1, 1, TimeUnit.SECONDS); // 每秒不超过10个任务被提交

    public static boolean acquired() {
        boolean flag = limiter.tryAcquire();
//        boolean flag = limiter.tryAcquire(1, TimeUnit.SECONDS);
        return flag;
    }


    @Test
    public void testWithRateLimiter() {
        Long start = System.currentTimeMillis();
        RateLimiter limiter = RateLimiter.create(2); // 每秒不超过10个任务被提交
        for (int i = 0; i < 10; i++) {
            double result = limiter.acquire(); // 请求RateLimiter, 超过permits会被阻塞
            System.out.println("call execute.." + i + " , result=" + result + " ,time=" + DateUtil.getYMDHMSTime());
        }
        Long end = System.currentTimeMillis();
        System.out.println(end - start);

    }

    @Test
    public void testRateLimiter() {
        Long start = System.currentTimeMillis();
        RateLimiter limiter = RateLimiter.create(100, 1, TimeUnit.SECONDS); // 每秒不超过10个任务被提交
        for (int i = 0; i < 100; i++) {
//            boolean flag = limiter.tryAcquire(99);
//            boolean flag = limiter.tryAcquire(99, 1, TimeUnit.SECONDS);
            boolean flag = limiter.tryAcquire(1, TimeUnit.SECONDS);
            System.out.println("call execute..flag = " + flag);
        }
        Long end = System.currentTimeMillis();
        System.out.println(end - start);

    }
}
