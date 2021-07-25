package com.mobei.sb.acutuator.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

/**
 * 自定义监控端点
 */
@Component
@Endpoint(id = "myservice")
public class MyServiceEndPoint {

    /**
     * 端点读操作: 该方法一定不能有传参
     *
     * @return
     */
    @ReadOperation
    public Map getDockerInfo() {
        //端点的读操作  http://server:port/actuator/myservice
        return Collections.singletonMap("dockerInfo", "docker started.....");
    }

    /**
     * 端点写操作
     */
    @WriteOperation
    public void stopDocker() {
        System.out.println("docker stopped.....");
    }

}
