package com.zah.app.model.node;

/**
 * Created by zah on 2017/6/7.
 */
public class ImgNode extends Node {
    public int img_type;//0:pg,1:gif,2:video

    public ImgNode(String imgUrl, String txt) {
        type = 1;
        this.url = imgUrl;
        if (url.endsWith("gif")) {
            img_type = 1;
        }
        this.txt = txt;
    }

    public ImgNode(String imgUrl) {
        this(imgUrl, null);
    }
}
