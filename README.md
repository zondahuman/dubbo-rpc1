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
















[zk: localhost:2181(CONNECTED) 2] ls2 /dubbo/com.abin.lee.dubbo.rpc.api.

com.abin.lee.dubbo.rpc.api.GlobalService   com.abin.lee.dubbo.rpc.api.DubboService
[zk: localhost:2181(CONNECTED) 2] ls2 /dubbo/com.abin.lee.dubbo.rpc.api.DubboService/
configurators   providers
[zk: localhost:2181(CONNECTED) 5] get /dubbo/com.abin.lee.dubbo.rpc.api.DubboService/configurators
192.168.0.103

[zk: localhost:2181(CONNECTED) 3] ls2 /dubbo/com.abin.lee.dubbo.rpc.api.DubboService/providers/dubbo%3A%2F%2F192.168.0.103%3A20880%2Fcom.abin.lee.dubbo.rpc.api.DubboService%3Fanyhost%3Dtrue%26applicat
ion%3Ddubbo-client%26default.service.filter%3DlogSessionFilter%26default.timeout%3D9000%26dubbo%3D2.0.1%26generic%3Dfalse%26interface%3Dcom.abin.lee.dubbo.rpc.api.DubboService%26methods%3DfindUserInfo
ById%2Cbuild%2CfindById%2CfindByParam%26pid%3D846368%26side%3Dprovider%26timestamp%3D1536485385082



interface com.abin.lee.dubbo.rpc.api.DubboService ->
dubbo://localhost:20880/com.abin.lee.dubbo.rpc.api.DubboService?application=dubbo-service&check=false&default.reference.filter=logSessionFilter&default.timeout=9000&dubbo=2.0.1&interface=com.abin.lee.dubbo.rpc.api.DubboService&methods=findUserInfoById,build,findById,findByParam&pid=843940&register.ip=192.168.0.103&side=consumer&timestamp=1536485772146