package com.zah.jpa.task;


import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
@EnableScheduling
public class TimerTask {
    @Scheduled(cron = "0 0/5 * * * ?") // 每5分钟执行一次
    public void createGen0Pig() {
    }
}