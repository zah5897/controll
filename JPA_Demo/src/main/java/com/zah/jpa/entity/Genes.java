package com.zah.jpa.entity;

import com.zah.jpa.data.GeneType;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by zah on 2018/4/10.
 */
@Entity
@Table(name = "genes")
public class Genes {

    @Id
    private int id;
    private int g0_shape;
    private GeneType g0_shape_type;
    private GeneType g0_color_type;
    private int g0_color;

    private int g1_shape;
    private GeneType g1_shape_type;
    private GeneType g1_color_type;
    private int g1_color;

    private int g2_shape;
    private GeneType g2_shape_type;
    private GeneType g2_color_type;
    private int g2_color;

    private int g3_shape;
    private GeneType g3_shape_type;
    private GeneType g3_color_type;
    private int g3_color;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getG0_shape() {
        return g0_shape;
    }

    public void setG0_shape(int g0_shape) {
        this.g0_shape = g0_shape;
    }

    public int getG0_color() {
        return g0_color;
    }

    public void setG0_color(int g0_color) {
        this.g0_color = g0_color;
    }

    public int getG1_shape() {
        return g1_shape;
    }

    public void setG1_shape(int g1_shape) {
        this.g1_shape = g1_shape;
    }

    public int getG1_color() {
        return g1_color;
    }

    public void setG1_color(int g1_color) {
        this.g1_color = g1_color;
    }

    public int getG2_shape() {
        return g2_shape;
    }

    public void setG2_shape(int g2_shape) {
        this.g2_shape = g2_shape;
    }

    public int getG2_color() {
        return g2_color;
    }

    public void setG2_color(int g2_color) {
        this.g2_color = g2_color;
    }

    public int getG3_shape() {
        return g3_shape;
    }

    public void setG3_shape(int g3_shape) {
        this.g3_shape = g3_shape;
    }

    public int getG3_color() {
        return g3_color;
    }

    public void setG3_color(int g3_color) {
        this.g3_color = g3_color;
    }

    public GeneType getG0_shape_type() {
        return g0_shape_type;
    }

    public void setG0_shape_type(GeneType g0_shape_type) {
        this.g0_shape_type = g0_shape_type;
    }

    public GeneType getG0_color_type() {
        return g0_color_type;
    }

    public void setG0_color_type(GeneType g0_color_type) {
        this.g0_color_type = g0_color_type;
    }

    public GeneType getG1_shape_type() {
        return g1_shape_type;
    }

    public void setG1_shape_type(GeneType g1_shape_type) {
        this.g1_shape_type = g1_shape_type;
    }

    public GeneType getG1_color_type() {
        return g1_color_type;
    }

    public void setG1_color_type(GeneType g1_color_type) {
        this.g1_color_type = g1_color_type;
    }

    public GeneType getG2_shape_type() {
        return g2_shape_type;
    }

    public void setG2_shape_type(GeneType g2_shape_type) {
        this.g2_shape_type = g2_shape_type;
    }

    public GeneType getG2_color_type() {
        return g2_color_type;
    }

    public void setG2_color_type(GeneType g2_color_type) {
        this.g2_color_type = g2_color_type;
    }

    public GeneType getG3_shape_type() {
        return g3_shape_type;
    }

    public void setG3_shape_type(GeneType g3_shape_type) {
        this.g3_shape_type = g3_shape_type;
    }

    public GeneType getG3_color_type() {
        return g3_color_type;
    }

    public void setG3_color_type(GeneType g3_color_type) {
        this.g3_color_type = g3_color_type;
    }
}
