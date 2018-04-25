package com.zhan.app.controll.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by zah on 2018/4/24.
 */
@Entity
@Table(name = "t_device")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class Device implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private long own_id;
    private String alis;
    private Date create_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getOwn_id() {
        return own_id;
    }

    public void setOwn_id(long own_id) {
        this.own_id = own_id;
    }

    public String getAlis() {
        return alis;
    }

    public void setAlis(String alis) {
        this.alis = alis;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}
