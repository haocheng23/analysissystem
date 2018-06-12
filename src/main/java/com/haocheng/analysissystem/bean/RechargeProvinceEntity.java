package com.haocheng.analysissystem.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "res_recharge_province")
public class RechargeProvinceEntity {

    @Id
    @GeneratedValue
    private String province;
    private Integer total;

    public RechargeProvinceEntity() {
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
        return "RechargeProvinceEntity{" +
                "province='" + province + '\'' +
                ", total=" + total +
                '}';
    }
}
