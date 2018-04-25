package com.zah.app.service;

import com.zah.app.model.ImageModel;
import com.zah.app.model.type.ChannelType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zah on 2017/6/7.
 */
@Service
public class HeiHeiService {
    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    HeiHeiPrepareService heiHeiPrepareService;

    public void save(ImageModel img) {
        String collectionName = ChannelType.values()[img.channel].name();
        if (!exist(img, collectionName)) {
            mongoTemplate.save(img, collectionName);
        }
    }

    public void save(List<ImageModel> imgs) {
        for (ImageModel img : imgs) {
            save(img);
        }
    }

    public boolean exist(ImageModel img, String collectionName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("detailUrl").is(img.detailUrl));
        return mongoTemplate.count(query, collectionName) > 0;
    }

    public void inJectData() {
        for (ChannelType channelType : ChannelType.values()) {
            boolean r = heiHeiPrepareService.moveImageModelData(channelType);
            if (!r) {
                System.out.println("no data to move!channelType=" + channelType);
            }
        }
    }
}
