package com.zah.app.spider;

import com.zah.app.spider.gif.BaseImgSpider;
import com.zah.app.spider.gif.DuoWanGifSpider;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zah on 2017/6/7.
 */
public class GifSpiderManager {
    private GifSpiderManager() {
        spiders = new ArrayList<>();
    }

    private static GifSpiderManager spiderManager;

    private List<BaseImgSpider> spiders;
    private int index = 0;

    public static GifSpiderManager get() {
        if (spiderManager == null) {
            spiderManager = new GifSpiderManager();
            spiderManager.initSpider();
        }
        return spiderManager;
    }

    private void initSpider() {
        spiders.add(new DuoWanGifSpider());
    }

    public void start() {
        if (index >= spiders.size()) {
            index = 0;
        }
        spiders.get(index).start();
    }
}
