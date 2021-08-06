package com.xzw.demoscheduled;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.xzw.demoscheduled.schedule.DemoSchedule;

@SpringBootTest
class DemoScheduledApplicationTests {
    @Autowired
    private DemoSchedule demoSchedule;

    @Test
    void contextLoads() {
        demoSchedule.printTime();
    }

}
