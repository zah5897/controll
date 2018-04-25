package com.zah.app.spider.base;

import com.zah.app.comm.err.SpiderException;
import com.zah.app.push.PushUtil;
import com.zah.app.util.spider.SpiderPraser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

/**
 * Created by zah on 2017/6/28.
 */
public class BaseSpider {
    public synchronized void start() {
    }


    protected Document getDoc(String url, String code) throws IOException {
        String src = SpiderPraser.getHtml(url, code);
        return SpiderPraser.toDoc(src);
    }

    protected Document getDocScroll(String url, String code) throws IOException {
        String src = SpiderPraser.getHtmlWithScroll(url, code);
        return SpiderPraser.toDoc(src);
    }

    protected String getTrimContent(String content) {
        return content.trim().replace(Jsoup.parse("&nbsp;").text(), "");
    }

    protected String getTrimContent(Element element) {
        return element.text().trim().replace(Jsoup.parse("&nbsp;").text(), "");
    }

    protected void reportErr(SpiderException err) {
        try {
            PushUtil.sendAndroidCustomizedcast(err.getSpiderName(), err.getMsg(), err.getUrl());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
