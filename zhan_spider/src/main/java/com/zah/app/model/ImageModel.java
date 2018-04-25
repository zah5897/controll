package com.zah.app.model;

import com.zah.app.model.node.Node;
import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * Created by zah on 2017/7/19.
 */
public class ImageModel {
    @Id
    public String id;
    public String thumb_img_url;
    public String title;
    public int thumb_img_width;
    public int thumb_img_height;
    public int channel;
    public String detailUrl;
    public int nodesCount;
    public List<Node> nodes;
}
