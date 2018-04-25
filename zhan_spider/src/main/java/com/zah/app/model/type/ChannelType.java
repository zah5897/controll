package com.zah.app.model.type;

/**
 * Created by zah on 2017/6/7.
 */
//  {"首页", "搞笑图集", "搞笑GIF","吐槽囧图", "美女图片", "搞笑段子","娱乐八卦"};


public enum ChannelType {
    HOT(0, "热门"),
    FUNNY(1, "搞笑"),
    JUNTU(2, "囧图"),
    GIF(3, "GIF"),
    NEIHAN(4, "内涵"),
    VIDEO(5, "视频"),
    TUCAO(6, "吐槽"),
    GIRL(7, "美女");
    private String _title;
    private int _value;

    private ChannelType(int value, String title) {
        _value = value;
        _title = title;
    }

    public String getTitle() {
        return _title;
    }

    public int getValue() {
        return _value;
    }
}
