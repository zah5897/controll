package com.zah.app.spider.gif;


import com.zah.app.SpringUtil;
import com.zah.app.model.GifModel;
import com.zah.app.model.type.ChannelType;
import com.zah.app.push.PushUtil;
import com.zah.app.service.GalleryService;
import com.zah.app.util.TextUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by zah on 2017/7/19.
 */
public class DuoWanGifSpider extends BaseImgSpider {
    String url = "http://tu.duowan.com/m/bxgif";
    boolean spidering = false;

    @Override
    public synchronized void start() {
        super.start();
        if (spidering) {
            return;
        }
        spidering = true;
        String encode = "utf8";
        try {
            System.out.println(DuoWanGifSpider.class.getName() + " start work!");
            Document doc = getDoc(url, encode);
//            Document doc = getDocScroll(url, encode);
            if (doc != null) {
                prase(doc);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("当前URL=" + url);
            PushUtil.sendAndroidCustomizedcast(this.getClass().getName(), e.getMessage(), url);
        }
        spidering = false;
    }

    private void prase(Document doc) throws IOException {
        Elements elements = doc.select("ul.pic-list").select(".masonry");
        if (elements.size() > 0) {
            Elements lis = elements.select("li.box").select(".masonry-brick");
            Collections.reverse(lis);
            for (Element e : lis) {
                if (!e.attr("class").equals("box masonry-brick")) {
                    continue;
                }
                Element aLink = e.select("a").get(1);
                Element img = e.select("img").get(0);
                String title = getTrimContent(aLink.text());
                if (TextUtils.isEmpty(title)) {
                    continue;
                }
                String detailUrl = aLink.attr("href");
                GalleryService service = SpringUtil.getBean(GalleryService.class);
                if (TextUtils.isEmpty(detailUrl)) {
                    continue;
                }

                Elements spans = e.select("span.txt>span.fr");
                int nodeCount = 0;
                if (spans.size() > 0) {
                    String countZStr = getTrimContent(spans.get(0));
                    try {
                        int count = Integer.parseInt(countZStr.substring(0, countZStr.length() - 1));
                        nodeCount = count;
                        if (count <= 0) {
                            nodeCount = 1000;
                        }
                    } catch (NumberFormatException numE) {
                        numE.printStackTrace();
                    }
                }
                if (nodeCount == 0) {
                    nodeCount = 1000;
                }
                praseImg(detailUrl, nodeCount, 1);
            }
        } else {
            throw new RuntimeException("div.i-list not exist.");
        }
    }


    private void praseImg(String detailUrl, int nodeCount, int index) {
        String encode = "utf8";
        String url = detailUrl;
        try {
            if (index > 1) {
                url += "#p" + index;
            }
            Document doc = getDoc(url, encode);
            Elements div_show_imgs = doc.select("div.show-img");
            if (div_show_imgs.size() > 0) {
                Elements imgs = div_show_imgs.get(0).select("img");
                if (imgs.size() > 0) {
                    String detailImgUrl = imgs.get(0).attr("src");
                    String comment = imgs.get(0).attr("alt");
                    GifModel gifModel = new GifModel();
                    gifModel.channel = ChannelType.Funny;
                    gifModel.img_url = detailImgUrl;
                    gifModel.description = comment;
                    if (TextUtils.isEmpty(gifModel.img_url) || TextUtils.isEmpty(gifModel.description)) {
                        throw new RuntimeException("imgmodel content is error url=" + url);
                    }
                    String subFix = detailImgUrl.substring(detailImgUrl.lastIndexOf(".") + 1);
                    if (subFix.equalsIgnoreCase("GIF")) {
                        SpringUtil.getBean(GalleryService.class).save(gifModel);
                    }
                    int nextP = index + 1;
                    if (nextP <= nodeCount) {
                        praseImg(detailUrl, nodeCount, nextP);
                    }
                }
            } else {
                System.err.println("div.show-img is empty.url=" + url);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


//    private GifModel praseImgDetail(Elements imgs) {
//        if (imgs.size() > 0) {
//            String detailImgUrl = imgs.get(0).attr("src");
//            String comment = imgs.get(0).attr("alt");
//            GifModel imageModel = new GifModel();
//            imageModel.img_url = detailImgUrl;
//            imageModel.description = comment;
//            return imageModel;
//        } else {
//            throw new RuntimeException("div.show-img>img is empty. imgs=" + imgs.html());
//        }
//    }

    public static void main(String[] args) {
        new DuoWanGifSpider().start();
    }

}
