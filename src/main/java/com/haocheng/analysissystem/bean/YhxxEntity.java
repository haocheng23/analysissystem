package com.haocheng.analysissystem.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "res_person")
public class YhxxEntity {
    @Id
    @GeneratedValue
    private Integer age;
    private String name;
    private String sex;
    private String idcard;
    private String tel;
    private String innet;
    private String point;
    private String road;
    private String email;

    public YhxxEntity(String name, String sex, String idcard, String tel, String innet, String point, String road, String email) {
        this.name = name;
        this.sex = sex;
        this.idcard = idcard;
        this.tel = tel;
        this.innet = innet;
        this.point = point;
        this.road = road;
        this.email = email;
    }

    public YhxxEntity() {
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInnet() {
        return innet;
    }

    public void setInnet(String innet) {
        this.innet = innet;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "YhxxEntity{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", idcard='" + idcard + '\'' +
                ", tel='" + tel + '\'' +
                ", innet='" + innet + '\'' +
                ", point='" + point + '\'' +
                ", road='" + road + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
