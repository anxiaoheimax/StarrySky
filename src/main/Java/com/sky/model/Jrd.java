package com.sky.model;

import java.util.List;

public class Jrd {
    //权限id
    private int JrdId;
    //权限名称
    private String title;
    //权限路径
    private String href;
    //权限父节点
    private int spId;
    //该节点的子节点数组
    private List<Jrd> children;

    public Jrd() {
    }

    public Jrd(int jrdId, String title, String href, int spId) {
        JrdId = jrdId;
        this.title = title;
        this.href = href;
        this.spId = spId;
    }

    public int getJrdId() {
        return JrdId;
    }

    public void setJrdId(int jrdId) {
        JrdId = jrdId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public int getSpId() {
        return spId;
    }

    public void setSpId(int spId) {
        this.spId = spId;
    }

    public List<Jrd> getChildren() {
        return children;
    }

    public void setChildren(List<Jrd> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Jrd{" +
                "JrdId=" + JrdId +
                ", title='" + title + '\'' +
                ", href='" + href + '\'' +
                ", spId=" + spId +
                ", children=" + children +
                '}';
    }
}
