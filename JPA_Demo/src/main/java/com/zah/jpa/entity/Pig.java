package com.zah.jpa.entity;

import javax.persistence.*;

/**
 * Created by zah on 2018/4/10.
 */
@Entity
@Table(name = "pig")
public class Pig {
    @Id
    private int id;
    private long birthTime;
    private long cooldownEndBlock;
    private int matronId;
    private int sireId;
    private int siringWithId;
    private int cooldownIndex;
    private int generation;

    private String owner;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genes")
    private Genes genes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public long getBirthTime() {
        return birthTime;
    }

    public void setBirthTime(long birthTime) {
        this.birthTime = birthTime;
    }

    public long getCooldownEndBlock() {
        return cooldownEndBlock;
    }

    public void setCooldownEndBlock(long cooldownEndBlock) {
        this.cooldownEndBlock = cooldownEndBlock;
    }

    public int getMatronId() {
        return matronId;
    }

    public void setMatronId(int matronId) {
        this.matronId = matronId;
    }

    public int getSireId() {
        return sireId;
    }

    public void setSireId(int sireId) {
        this.sireId = sireId;
    }

    public int getSiringWithId() {
        return siringWithId;
    }

    public void setSiringWithId(int siringWithId) {
        this.siringWithId = siringWithId;
    }

    public int getCooldownIndex() {
        return cooldownIndex;
    }

    public void setCooldownIndex(int cooldownIndex) {
        this.cooldownIndex = cooldownIndex;
    }

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public String getOwner() {
        return owner;
    }

    public Genes getGenes() {
        return genes;
    }

    public void setGenes(Genes genes) {
        this.genes = genes;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
