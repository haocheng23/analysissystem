package com.haocheng.analysissystem.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "res_recharge_time")
public class RechargeTimeEntity {
    @Id
    @GeneratedValue
    private Integer hour;
    private Integer total;
    private Integer march;
    private Integer april;
    private Integer may;

    public RechargeTimeEntity() {
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getMarch() {
        return march;
    }

    public void setMarch(Integer march) {
        this.march = march;
    }

    public Integer getApril() {
        return april;
    }

    public void setApril(Integer april) {
        this.april = april;
    }

    public Integer getMay() {
        return may;
    }

    public void setMay(Integer may) {
        this.may = may;
    }

    @Override
    public String toString() {
        return "RechargeTimeEntity{" +
                "hour=" + hour +
                ", total=" + total +
                ", march=" + march +
                ", april=" + april +
                ", may=" + may +
                '}';
    }
}
