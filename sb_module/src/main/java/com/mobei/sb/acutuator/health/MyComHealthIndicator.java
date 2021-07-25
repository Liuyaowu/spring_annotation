package com.mobei.sb.acutuator.health;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 自定义健康检查组件
 */
@Component
public class MyComHealthIndicator extends AbstractHealthIndicator {

    /**
     * 真实的检查方法
     *
     * @param builder
     * @throws Exception
     */
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        //建设检测mongodb: 获取连接进行测试
        Map<String, Object> map = new HashMap<>();
        // 检查完成
        if (1 == 1) {
//            builder.up(); //健康
            builder.status(Status.UP);

            // 检测完可能会需要携带一些其它数据
            map.put("count", 1);
            map.put("ms", 100);
        } else {
//            builder.down();
            builder.status(Status.OUT_OF_SERVICE);
            map.put("err", "连接超时");
            map.put("ms", 3000);
        }

        builder.withDetail("code", 100).withDetails(map);
    }
}
