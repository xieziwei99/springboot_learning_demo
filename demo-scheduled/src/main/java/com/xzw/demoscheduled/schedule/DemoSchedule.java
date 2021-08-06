package com.xzw.demoscheduled.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author xieziwei <xieziwei@kuaishou.com>
 * Created on 2021-08-06
 */
@Component
public class DemoSchedule {
    private static final Logger logger = LoggerFactory.getLogger(DemoSchedule.class);

    @Scheduled(cron = "*/3 * * * * ?")
    public void printTime() {
        logger.info("" + System.currentTimeMillis());
    }
}
