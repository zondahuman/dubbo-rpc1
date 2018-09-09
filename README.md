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