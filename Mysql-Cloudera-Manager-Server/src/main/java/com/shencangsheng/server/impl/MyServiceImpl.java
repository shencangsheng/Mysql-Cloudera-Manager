/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: MyServiceImpl
 * Author:   shencangsheng
 * Date:     2021/9/23 5:33 下午
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.shencangsheng.server.impl;

import com.shencangsheng.lib.HelloReply;
import com.shencangsheng.lib.HelloRequest;
import com.shencangsheng.lib.MyServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author shencangsheng
 * @create 2021/9/23
 * @since 1.0.0
 */
@GrpcService
public class MyServiceImpl extends MyServiceGrpc.MyServiceImplBase {

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        System.out.println(request.getName());
        HelloReply reply = HelloReply.newBuilder()
                .setMessage("Hello ==> " + request.getName())
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

}