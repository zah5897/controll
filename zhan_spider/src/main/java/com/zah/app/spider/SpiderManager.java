package com.zah.app.spider;

import com.zah.app.spider.base.BaseSpider;
import com.zah.app.spider.duowan.GifSpider;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zah on 2017/6/7.
 */
public class SpiderManager {
    private SpiderManager() {
        baseSpider = new HashMap<>();
        baseSpider.put(GifSpider.class.getName(), new GifSpider());
    }

    private Map<String, BaseSpider> baseSpider;

    private static SpiderManager spiderManager;

    public static SpiderManager get() {
        if (spiderManager == null) {
            spiderManager = new SpiderManager();
        }
        return spiderManager;
    }

    public void start() {
        for (BaseSpider spider : baseSpider.values()) {
            spider.start();
        }
    }

    public BaseSpider getSpider(Class<?> clazz) {
        return baseSpider.get(clazz.getName());
    }
}
