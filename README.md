march action

dubbo RPC:

dubbo traceId

dubbo tracking the chain

TraceIdUtil 里面维护一个ThreadLocal<String>
InvokerInvocationHandler 里面设置traceId
RpcContext.getContext().setAttachment("traceId", traceId);

DubboProtocol里面接收traceId
TraceIdUtil.setTraceId(inv.getAttachment("traceId"));



