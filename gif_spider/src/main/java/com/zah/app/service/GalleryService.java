package com.zah.app.service;

import com.zah.app.model.GifModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

/**
 * Created by zah on 2017/6/7.
 */
@Service
public class GalleryService {
    @Autowired
    MongoTemplate mongoTemplate;


    public void save(GifModel img) {
        if (!exist(img)) {
            mongoTemplate.save(img, img.channel.name());
        }
    }


    public boolean exist(GifModel img) {
        Query query = new Query();
        query.addCriteria(Criteria.where("description").is(img.description).and("img_url").is(img.img_url));
        return mongoTemplate.count(query, img.channel.name()) > 0;
    }

}
