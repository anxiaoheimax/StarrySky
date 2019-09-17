package com.sky.model;
//详情
public class Details {
    //详情编号
    private int detailsId;
    //座位号/包间号
    private int orderId;
    //酒品编号
    private int liquorId;
    //单品数量
    private int number;
    //

    public Details() {
    }

    public Details(int orderId, int liquorId, int number) {
        this.orderId = orderId;
        this.liquorId = liquorId;
        this.number = number;
    }

    public Details(int detailsId, int orderId, int liquorId, int number) {
        this.detailsId = detailsId;
        this.orderId = orderId;
        this.liquorId = liquorId;
        this.number = number;
    }

    public int getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(int detailsId) {
        this.detailsId = detailsId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
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

    @Override
    public String toString() {
        return "Details{" +
                "detailsId=" + detailsId +
                ", compId=" + orderId +
                ", liquorId=" + liquorId +
                ", number=" + number +
                '}';
    }
}
