package com.haocheng.analysissystem.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "res_personvip")
public class VipEntity {
    @Id
    @GeneratedValue
    private String level;
    private Integer total;
    private Integer male;
    private Integer famale;


    public VipEntity() {
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getMale() {
        return male;
    }

    public void setMale(Integer male) {
        this.male = male;
    }

    public Integer getFamale() {
        return famale;
    }

    public void setFamale(Integer famale) {
        this.famale = famale;
    }

    @Override
    public String toString() {
        return "VipEntity{" +
                "level='" + level + '\'' +
                ", total=" + total +
                ", male=" + male +
                ", famale=" + famale +
                '}';
    }
}
