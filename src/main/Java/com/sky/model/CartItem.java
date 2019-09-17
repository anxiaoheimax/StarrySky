package com.sky.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
public class CartItem implements Serializable {
    //id
    private int cartId;
    //酒品ID
    private int liquorId;
    //数量
    private int number;
    //总价
    private int total_price;
    //用户id
    private int uid;
    //酒品对象
    private Liquor liquor;

    public CartItem() {
    }

    public CartItem(int liquorId, int number, int uid) {
        this.liquorId = liquorId;
        this.number = number;
        this.uid = uid;
    }


    public CartItem(int cartId, int liquorId, int number, int total_price, int uid) {
        this.cartId = cartId;
        this.liquorId = liquorId;
        this.number = number;
        this.total_price = total_price;
        this.uid = uid;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getLiquorId() {
        return liquorId;
    }

    public void setLiquorId(int liquorId) {
        this.liquorId = liquorId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getTotal_price() {
        return total_price;
    }

    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public Liquor getLiquor() {
        return liquor;
    }

    public void setLiquor(Liquor liquor) {
        this.liquor = liquor;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "cartId=" + cartId +
                ", liquorId=" + liquorId +
                ", number=" + number +
                ", total_price=" + total_price +
                ", uid=" + uid +

                ", liquor=" +getLiquor() +
                '}';
    }










    /* */
}