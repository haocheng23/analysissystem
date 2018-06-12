package com.haocheng.analysissystem.vo;

public class PieVo {
    private String type;
    private int count;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "PieVo{" +
                "type='" + type + '\'' +
                ", count=" + count +
                '}';
    }
}
