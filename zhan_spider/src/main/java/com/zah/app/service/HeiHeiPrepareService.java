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
public class HeiHeiPrepareService {
    String collectionName = "DATA_QUEUE";
    @Autowired
    MongoTemplate mongoTemplate;

    public void saveQueue(ImageModel img) {

        if (!exist(img)) {
            mongoTemplate.save(img, collectionName);
        }
    }

    public void saveQueue(List<ImageModel> imgs) {
        for (ImageModel img : imgs) {
            saveQueue(img);
        }
    }

    public boolean exist(ImageModel img) {
        Query query = new Query();
        query.addCriteria(Criteria.where("img_url").is(img.thumb_img_url).and("channel").is(img.channel));
        return mongoTemplate.count(query, collectionName) > 0;
    }

    public boolean hasSpider(ImageModel imageModel) {
        Query query = new Query();
        query.addCriteria(Criteria.where("detailUrl").is(imageModel.detailUrl).and("channel").is(imageModel.channel));
        boolean hasSpider = mongoTemplate.count(query, collectionName) > 0;
        if (hasSpider) {
            return hasSpider;
        }
        hasSpider = mongoTemplate.count(query, ChannelType.values()[imageModel.channel].name()) > 0;
        return hasSpider;
    }

    public boolean moveImageModelData(ChannelType channelType) {
        Query query = new Query();
        query.addCriteria(Criteria.where("channel").is(channelType.ordinal()));
        ImageModel model = mongoTemplate.findOne(query, ImageModel.class, collectionName);
        if (model != null) {
            mongoTemplate.save(model, channelType.name());
            mongoTemplate.remove(model, collectionName);
            return true;
        }
        return false;
    }
}
