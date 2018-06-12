package com.haocheng.analysissystem.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "servicer_entity")
public class KfxxEntity {

    @Id
    @GeneratedValue
    private String jobnum;
    private String name;

    public KfxxEntity() {
    }

    public KfxxEntity(String name) {
        this.name = name;
    }

    public String getJobnum() {
        return jobnum;
    }

    public void setJobnum(String jobnum) {
        this.jobnum = jobnum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "KfxxEntity{" +
                "jobnum='" + jobnum + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
