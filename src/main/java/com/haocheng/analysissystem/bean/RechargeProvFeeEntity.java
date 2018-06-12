package com.haocheng.analysissystem.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "res_recharge_provfee")
public class RechargeProvFeeEntity {
    @Id
    @GeneratedValue
    private String province;
    private Integer total;

    public RechargeProvFeeEntity() {
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "RechargeProvFeeEntity{" +
                "province='" + province + '\'' +
                ", total=" + total +
                '}';
    }
}
