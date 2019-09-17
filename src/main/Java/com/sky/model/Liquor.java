package com.sky.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;

//酒的实体类

@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
public class Liquor implements Serializable {
    //id
    private int liquorId;
    //酒名
    private String liquor_name;
    //品牌
    private Brand brand;
    //产地
    private String origin;
    //价格
    private int price;
    //生产时间
    private Date production_date;
    //酒精浓度
    private float alcoholic_strength;
    //样图
    private String picture;
    //类型
    private Kind kind;

    public Liquor() {
        System.out.println("Liquor空构造");
    }

    public Liquor(int liquorId) {
        this.liquorId = liquorId;
    }

    public Liquor(String liquor_name, String origin) {
        this.liquor_name = liquor_name;
        this.origin = origin;
        System.out.println("测试两个参数的构造");
    }

    public Liquor(int liquorId, int price) {
        this.liquorId = liquorId;
        this.price = price;
    }

    public Liquor(String liquor_name, String origin, Date production_date) {
        this.liquor_name = liquor_name;
        this.origin = origin;
        this.production_date = production_date;
    }
    //没有图片

    public Liquor(int liquorId, String liquor_name, Brand brand, String origin, int price, Date production_date, float alcoholic_strength, Kind kind) {
        this.liquorId = liquorId;
        this.liquor_name = liquor_name;
        this.brand = brand;
        this.origin = origin;
        this.price = price;
        this.production_date = production_date;
        this.alcoholic_strength = alcoholic_strength;
        this.kind = kind;
    }

    //没有id 图

    public Liquor(String liquor_name, Brand brand, String origin, int price, Date production_date, float alcoholic_strength, Kind kind) {
        this.liquor_name = liquor_name;
        this.brand = brand;
        this.origin = origin;
        this.price = price;
        this.production_date = production_date;
        this.alcoholic_strength = alcoholic_strength;
        this.kind = kind;
    }

    //全参
    public Liquor(int liquorId, String liquor_name, Brand brand, String origin, int price, Date production_date, float alcoholic_strength, String picture, Kind kind) {
        System.out.println("全参");
        this.liquorId = liquorId;
        this.liquor_name = liquor_name;
        this.brand = brand;
        this.origin = origin;
        this.price = price;
        this.production_date = production_date;
        this.alcoholic_strength = alcoholic_strength;
        this.picture = picture;
        this.kind = kind;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Kind getKind() {
        return kind;
    }

    public void setKind(Kind kind) {
        this.kind = kind;
    }

    public int getLiquorId() {
        return liquorId;
    }

    public void setLiquorId(int id) {
        this.liquorId = id;
    }

    public String getLiquor_name() {
        return liquor_name;
    }

    public void setLiquor_name(String liquor_name) {
        this.liquor_name = liquor_name;
    }
    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getProduction_date() {
        return production_date;
    }

    public void setProduction_date(Date production_date) {

        this.production_date = production_date;
    }

    public float getAlcoholic_strength() {

        return alcoholic_strength;
    }

    public void setAlcoholic_strength(float alcoholic_strength) {

        this.alcoholic_strength = alcoholic_strength;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture)
    {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Liquor{" +
                "id=" + liquorId +
                ", liquor_name='" + liquor_name + '\'' +
                ", brand='" + getBrand() + '\'' +
                ", origin='" + origin + '\'' +
                ", price=" + price +
                ", production_date=" + production_date +
                ", alcoholic_atrength=" + alcoholic_strength +
                ", picture='" + picture + '\'' +
                ", kind='" + getKind() + '\'' +
                '}';
    }
}
