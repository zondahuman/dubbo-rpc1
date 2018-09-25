march action

dubbo RPC:

dubbo traceId

dubbo tracking the chain

TraceIdUtil 里面维护一个ThreadLocal<String>

consumer调用时候通过
TraceIdUtil.setTraceId(TRACE_ID);
设置进去，这样子，系统多次调用dubbo，使用的同一个TRACE_ID,  如果只是简单的在consumer和provider各自实现一个filter的话，
如果consumer，多次调用dubbo一个方法或者多个方法，TRACE_ID会不同，达不到日志跟踪的目的


InvokerInvocationHandler 里面设置traceId
RpcContext.getContext().setAttachment("traceId", traceId);

DubboProtocol里面接收traceId
TraceIdUtil.setTraceId(inv.getAttachment("traceId"));



https://blog.csdn.net/coolsky600/article/details/63684046



/dubbo/com.abin.lee.dubbo.rpc.api.DubboService/configurators
/dubbo/com.abin.lee.dubbo.rpc.api.DubboService/providers

/dubbo/com.abin.lee.dubbo.rpc.api.DubboService/providers/dubbo://192.168.0.103:20880/com.abin.lee.dubbo.rpc.api.DubboService?anyhost=true&applicat
ion=dubbo-client&default.service.filter=logSessionFilter&default.timeout=9000&dubbo=2.0.1&generic=false&interface=com.abin.lee.dubbo.rpc.api.DubboService&methods=findUserInfo
ById,build,findById,findByParam&pid=846368&side=provider&timestamp=1536485385082

[zk: localhost:2181(CONNECTED) 5] get /dubbo/com.abin.lee.dubbo.rpc.api.DubboService/configurators
192.168.0.103





dubbo mock:
http://dubbo.incubator.apache.org/zh-cn/docs/user/demos/local-mock.html

主流框架的适配
https://github.com/alibaba/Sentinel/wiki/%E4%B8%BB%E6%B5%81%E6%A1%86%E6%9E%B6%E7%9A%84%E9%80%82%E9%85%8D












在线unicode转中文,中文转unicode
http://www.bejson.com/convert/unicode_chinese/