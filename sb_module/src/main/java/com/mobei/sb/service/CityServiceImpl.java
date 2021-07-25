package com.mobei.sb.service;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl {

    Counter counter;

    /**
     * 指标注册: 统计cityService的saveCity被调用的次数,
     *
     * 可以通过http://server:port/actuator/metrics/cityService.saveCity.count查看最后的调用次数
     *
     * @param meterRegistry
     */
    public CityServiceImpl(MeterRegistry meterRegistry){
        counter = meterRegistry.counter("cityService.saveCity.count");
    }

    public void saveCity() {
        counter.increment();
        System.out.println("save city");
    }

}
