package com.haocheng.analysissystem.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "res_payway")
public class PayWayEntity {
    @Id
    @GeneratedValue
    private String payway;
    private String total;

    public PayWayEntity() {
    }

    public PayWayEntity(String total) {
        this.total = total;
    }

    public String getPayway() {
        return payway;
    }

    public void setPayway(String payway) {
        this.payway = payway;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "PayWayEntity{" +
                "payway='" + payway + '\'' +
                ", total='" + total + '\'' +
                '}';
    }
}
