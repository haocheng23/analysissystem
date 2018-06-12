package com.haocheng.analysissystem.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "res_recharge_fee")
public class RechargeFeeEntity {
    @Id
    @GeneratedValue
    private String rechargefee;
    private String total;

    public RechargeFeeEntity() {
    }



    public String getRechargefee() {
        return rechargefee;
    }

    public void setRechargefee(String rechargefee) {
        this.rechargefee = rechargefee;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "RechargeEntity{" +
                "rechargefee='" + rechargefee + '\'' +
                ", total='" + total + '\'' +
                '}';
    }
}
