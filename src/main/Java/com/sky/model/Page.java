package com.sky.model;

import java.util.HashMap;
import java.util.List;

//分页
public class Page<T> {
    //当前页
    private int pageNow;
    //每页显示多少条数据
    private int pageRows;
    //总页数
    private int totalPages;
    //总共多少条记录
    private int totalRows;
    //每页的数据
    private List<T> datas;
    //开始下标
    private int startIndex;
    //条件集合
    private HashMap condition = new HashMap();

    public Page() {
    }
    //两个参数的构造方法
    public Page(int pageNow, int pageRows) {
        //当前页
        this.pageNow = pageNow;
        //每页显示
        this.pageRows = pageRows;
    }

    public int getStartIndex() {
        return (getPageNow()-1)*getPageRows();
    }

    public void setStartIndex() {
        //计算起始下标
        this.startIndex =startIndex;
    }

    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    public int getPageRows() {
        return pageRows;
    }

    public void setPageRows(int pageRows) {
        this.pageRows = pageRows;
    }

    public int getTotalPages() {
        totalPages = totalRows%pageRows==0?totalRows/pageRows:totalRows/pageRows+1;
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }

    public HashMap getCondition() {
        return condition;
    }

    public void setCondition(HashMap condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNow=" + pageNow +
                ", pageRows=" + pageRows +
                ", totalPages=" + getTotalPages()+
                ", totalRows=" + totalRows +
                ", datas=" + datas +
                '}';
    }
}
