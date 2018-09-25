package com.abin.lee.dubbo.rpc.provider.exception;

/**
 * Created by abin on 2018/9/25.
 */
public class ExceptionUtil extends Exception {

    //无参构造方法
    public ExceptionUtil() {
        super();
    }

    //有参的构造方法
    public ExceptionUtil(String message) {
        super(message);
    }

    // 用指定的详细信息和原因构造一个新的异常
    public ExceptionUtil(String message, Throwable cause) {
        super(message, cause);
    }

    //用指定原因构造一个新的异常
    public ExceptionUtil(Throwable cause) {
        super(cause);
    }

    //用指定原因构造一个新的异常
    public static void handleException() throws ExceptionUtil {
        throw new ExceptionUtil("An Sentinel Exception For Provider");
    }

}
