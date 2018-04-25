package com.zah.app.spider.duowan;


import com.zah.app.SpringUtil;
import com.zah.app.model.ImageModel;
import com.zah.app.model.node.ImgNode;
import com.zah.app.model.type.ChannelType;
import com.zah.app.push.PushUtil;
import com.zah.app.service.HeiHeiPrepareService;
import com.zah.app.service.HeiHeiService;
import com.zah.app.spider.base.BaseSpider;
import com.zah.app.util.TextUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.omg.CORBA.INTERNAL;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by zah on 2017/7/19.
 */
public class GifSpider extends BaseSpider {
    String url = "http://tu.duowan.com/m/bxgif";
    boolean spidering = false;
    String encode = "utf8";

    @Override
    public synchronized void start() {
        super.start();
        if (spidering) {
            return;
        }
        spidering = true;
        try {
            List<ImageModel> listModels = praseListPage();
            for (ImageModel imageModel : listModels) {
                boolean r = SpringUtil.getBean(HeiHeiPrepareService.class).hasSpider(imageModel);
                if (r) {
                    continue;
                }
                imageModel.nodes = new ArrayList<>();
                praseNodes(imageModel, 1);

                if (imageModel.nodes.size() == 0) {
                    throw new RuntimeException("nodes is empty.");
                }
                SpringUtil.getBean(HeiHeiPrepareService.class).saveQueue(imageModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("当前URL=" + url);
            PushUtil.sendAndroidCustomizedcast(this.getClass().getName(), e.getMessage(), url);
        }
        spidering = false;
    }

    private List<ImageModel> praseListPage() throws IOException {
        Document doc = getDoc(url, encode);
        Elements lis = doc.select("li.box").select(".masonry-brick");
        if (lis.size() == 0) {
            return null;
        }
        Collections.reverse(lis);
        List<ImageModel> imageModels = new ArrayList<>();
        for (Element e : lis) {
            if (!e.attr("class").equals("box masonry-brick")) {
                continue;
            }
            Element aLink = e.select("a").get(0);
            String detail_page_url = aLink.attr("href");
            if (TextUtils.isEmpty(detail_page_url)) {
                System.out.println("detail_page_url is empty");
                continue;
            }


            Element img = aLink.select("img").get(0);

            String thumb_img_url = img.attr("src");
            String heightStr = img.attr("height");
            int height = Integer.parseInt(heightStr);
            int nodesCount = 0;
            Elements spans = doc.select("span.txt>span.fr");
            if (spans.size() > 0) {
                String countZStr = getTrimContent(spans.get(0));
                try {
                    nodesCount = Integer.parseInt(countZStr.substring(0, countZStr.length() - 1));
                    if (nodesCount <= 0) {
                        nodesCount = 1000;
                    }
                } catch (NumberFormatException numE) {
                    numE.printStackTrace();
                }
            }
            if (nodesCount == 0) {
                nodesCount = 1000;
            }

            Elements ems = e.select("em");
            String descript = null;
            if (ems.size() > 0) {
                descript = getTrimContent(ems.get(0).select("a").get(0).text());
                if (descript.startsWith("全球搞笑GIF图第")) {
                    descript = descript.substring(descript.indexOf("：") + 1);
                }
            }


            if (TextUtils.isEmpty(detail_page_url)) {
                throw new RuntimeException("detailUrl is null");
            }
            if (TextUtils.isEmpty(descript)) {
                throw new RuntimeException("title is null");
            }
            if (TextUtils.isEmpty(thumb_img_url)) {
                throw new RuntimeException("thumb_img_url is null");
            }

            ImageModel imageModel = new ImageModel();
            imageModel.detailUrl = detail_page_url;
            imageModel.title = descript;

            imageModel.thumb_img_url = thumb_img_url;
            imageModel.thumb_img_height = height;
            imageModel.thumb_img_width = 195;

            imageModel.nodesCount = nodesCount;
            imageModel.channel = ChannelType.GIF.ordinal();
            imageModels.add(imageModel);
        }
        return imageModels;
    }

    private void praseNodes(ImageModel imageModel, int pageIndex) throws IOException {
        String url = imageModel.detailUrl;
        if (pageIndex > 1) {
            url += "#p" + pageIndex;
        }
        Document doc = getDoc(url, encode);
        Elements aFull = doc.select("div.tips").select(".clearfix").get(0).select("div.fr").get(0).select("a.full");
        String origin_img_url;
        if (aFull.size() > 0) {
            Element a = aFull.get(0);
            if (a.attr("id").equals("full")) {
                origin_img_url = a.attr("href");
                Elements pic_intros = doc.select("p#pic-intro");
                if (pic_intros.size() > 0) {
                    String comment = getTrimContent(pic_intros.get(0));
                    ImgNode imgNode = new ImgNode(origin_img_url, comment);
                    imageModel.nodes.add(imgNode);
                    int nextP = pageIndex + 1;
                    if (nextP <= imageModel.nodesCount) {
                        System.out.println("while spider next! pageIndex=" + nextP);
                        praseNodes(imageModel, nextP);
                    }
                }

            }
        }
    }

    public static void main(String[] args) {
        new GifSpider().start();
    }

}
