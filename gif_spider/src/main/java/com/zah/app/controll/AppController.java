package com.zah.app.controll;

import com.zah.app.spider.SpiderManager;
import com.zah.app.util.RTUtil;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by zah on 2017/5/22.
 */
@RestController
public class AppController {
    //    public static Logger logger = LoggerFactory.getLogger(AppController.class);
    @Resource
    MongoTemplate mongoTemplateStar;

    @RequestMapping("/getApps")
    public ModelMap getApps() throws SQLException {

        return RTUtil.getOKMap();
    }

    @RequestMapping("/spider_star")
    public ModelMap spider_star() throws SQLException {
        new Thread() {
            @Override
            public void run() {
                super.run();
                SpiderManager.get().start();
            }
        }.start();
        return RTUtil.getOKMap();
    }
}
