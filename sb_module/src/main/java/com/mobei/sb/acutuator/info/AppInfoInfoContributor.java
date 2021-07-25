package com.mobei.sb.acutuator.info;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * 自定义info信息
 */
@Component
public class AppInfoInfoContributor implements InfoContributor {

    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("msg","你好")
                .withDetail("hello","atguigu")
                .withDetails(Collections.singletonMap("world","666600"));
    }

}
