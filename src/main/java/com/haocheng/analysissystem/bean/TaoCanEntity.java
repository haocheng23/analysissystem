package com.haocheng.analysissystem.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "res_taocan")
public class TaoCanEntity {
    @Id
    @GeneratedValue
    private String taocan;
    private String total;

    public TaoCanEntity() {
    }

    public TaoCanEntity(String taocan, String total) {
        this.taocan = taocan;
        this.total = total;
    }

    public String getTaocan() {
        return taocan;
    }

    public void setTaocan(String taocan) {
        this.taocan = taocan;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "TaoCanEntity{" +
                "taocan='" + taocan + '\'' +
                ", total='" + total + '\'' +
                '}';
    }
}
