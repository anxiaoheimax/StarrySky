package com.sky.model;
//酒的类型
public class Kind {
    //id
    private int kindId;
    //类型
    private String kindName;

    public Kind() {
    }

    public Kind(String  kindId) {
        this.kindId = Integer.parseInt(kindId);
    }
    public Kind(int kindId) {
        this.kindId = kindId;
    }


    public Kind(int kindId, String kindName) {
        this.kindId = kindId;
        this.kindName = kindName;
    }

    public int getKindId() {
        return kindId;
    }

    public void setKindId(int kindId) {
        this.kindId = kindId;
    }

    public String getKindName() {
        return kindName;
    }

    public void setKindName(String kindName) {
        this.kindName = kindName;
    }

    @Override
    public String toString() {
        return "Kind{" +
                "kindId=" + kindId +
                ", kindName='" + kindName + '\'' +
                '}';
    }
}
