package com.zah.app;

import com.zah.app.service.HeiHeiService;
import com.zah.app.spider.SpiderManager;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by zah on 2017/6/7.
 */
@Configuration
@EnableScheduling // 启用定时任务
@Component
public class SchedulingConfig {

    //@Scheduled(cron = "0 0 0/1 * * ?") // 每小時
//    @Scheduled(cron = "0 0/5 * * * ?") // 每5分钟执行一次
   // @Scheduled(cron = "0/30 * * * * ?") // 每30秒执行一次
    public void scheduler() {
        //  SpiderManager.get().start();
    }

    //@Scheduled(cron = "0 0 0/1 * * ?") // 每小時
    @Scheduled(cron = "0 59 23 * * ?") // 每天23：59分执行
//    @Scheduled(cron = "0/30 * * * * ?") // 每20秒执行一次
    public void schedulerStar() {
        System.out.println("spider start.");
        SpiderManager.get().start();
    }


    @Scheduled(cron = "0 0/59 * * * ?") // 每30分钟执行一次
    public void injectData() {
        System.out.println("injectData");
        SpringUtil.getBean(HeiHeiService.class).inJectData();
    }
}
