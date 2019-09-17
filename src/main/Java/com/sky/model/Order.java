package com.sky.model;

import com.fasterxml.jackson.annotation.JsonFormat;

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
    //结算状态
    private int payment;

    //订单日期
    private Date order_date;

    public Order() {
    }

    public Order(int Uid, int compId, int money, int payment) {
        this.Uid = Uid;
        this.compId = compId;
        this.money = money;
        this.payment = payment;
    }

    public Order(int orderId, int Uid, int compId, int money, int payment, Date order_date) {
        this.orderId = orderId;
        this.Uid = Uid;
        this.compId = compId;
        this.money = money;
        this.payment = payment;
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

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", Uid=" + Uid +
                ", compId=" + compId +
                ", money=" + money +
                ", payment=" + payment +
                ", order_date=" + order_date +
                '}';
    }
}
