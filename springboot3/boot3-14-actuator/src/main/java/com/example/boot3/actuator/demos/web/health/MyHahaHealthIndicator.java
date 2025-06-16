package com.example.boot3.actuator.demos.web.health;

import com.example.boot3.actuator.demos.web.component.MyHahaComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * 功能描述
 *
 * @author: Gxf
 * @date: 2025年06月04日 11:50
 */
@Component
public class MyHahaHealthIndicator implements HealthIndicator {

    @Autowired
    MyHahaComponent myHahaComponent;

    @Override
    public Health health() {
        int check = myHahaComponent.check();
        if (check == 1) {
            return Health.up()
                    .withDetail("code", "10000")
                    .withDetail("msg", "success")
                    .withDetail("data", "myHahaComponent")
                    .build();
        } else {
            return Health.down()
                    .withDetail("code", "20000")
                    .withDetail("msg", "fail")
                    .withDetail("data", "myHahaComponent")
                    .build();
        }
    }

}
