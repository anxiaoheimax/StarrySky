package com.sky.model;

import java.util.Date;

//订单
public class Order {
    //订单编号
    private int orderId;
    //用户id
    private int Uid;
    //卡座或者包间的编号
    private int compId;
    //订单消费金额
    private int money;
    //订单详情编号
    private int detailsId;
    //订单日期
    private Date order_date;

    public Order() {
    }

    public Order(int orderId, int uid, int compId, int money, int detailsId, Date order_date) {
        this.orderId = orderId;
        Uid = uid;
        this.compId = compId;
        this.money = money;
        this.detailsId = detailsId;
        this.order_date = order_date;
    }

    public Order(int uid, int compId, int money, int detailsId, Date order_date) {
        Uid = uid;
        this.compId = compId;
        this.money = money;
        this.detailsId = detailsId;
        this.order_date = order_date;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUid() {
        return Uid;
    }

    public void setUid(int uid) {
        Uid = uid;
    }

    public int getCompId() {
        return compId;
    }

    public void setCompId(int compId) {
        this.compId = compId;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(int detailsId) {
        this.detailsId = detailsId;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", Uid=" + Uid +
                ", compId=" + compId +
                ", money=" + money +
                ", detailsId=" + detailsId +
                ", order_date=" + order_date +
                '}';
    }
}
