package com.example.boot3.actuator.demos.web.component;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

/**
 * 功能描述
 *
 * @author: Gxf
 * @date: 2025年06月04日 11:50
 */
@Component
public class MyHahaComponent {

    Counter counter = null;

    public MyHahaComponent(MeterRegistry meterregistry) {
        counter = meterregistry.counter("myhaha.hello");
    }

    public int check() {
        return 1;
    }

    public void hello() {
        System.out.println("Hello Spring Actuator!");
        counter.increment();
    }

}
