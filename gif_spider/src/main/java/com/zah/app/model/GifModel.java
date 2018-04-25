package com.zah.app.model;

import com.zah.app.model.type.ChannelType;
import org.springframework.data.annotation.Transient;

import java.util.List;

/**
 * Created by zah on 2017/7/19.
 */
public class GifModel {
    public String description;
    public String img_url;
    public int thumb_height;
    public int thumb_width;
    @Transient
    public ChannelType channel;
}
