package com.currencyexchange.currencyExchange.config.grpc;

import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import lombok.extern.java.Log;
import net.devh.boot.grpc.server.interceptor.GrpcGlobalServerInterceptor;


@Log
public class LogGrpcInterceptor implements ServerInterceptor {
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
            ServerCall<ReqT, RespT> serverCall,
            Metadata metadata,
            ServerCallHandler<ReqT, RespT> serverCallHandler) {

        log.info(serverCall.getMethodDescriptor().getFullMethodName());
        return serverCallHandler.startCall(serverCall, metadata);
    }

}
