package com.example.test.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class S_data {
    private int id;
    private String devid;
    private float hum;
    private float tem;
    private int rain;
    private String north;
    private String east;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone= "GMT+8")
    private Date datatime;

    public S_data(int id, String devid, float hum, float tem, int rain, String north, String east, Date datatime) {
        this.id = id;
        this.devid = devid;
        this.hum = hum;
        this.tem = tem;
        this.rain = rain;
        this.north = north;
        this.east = east;
        this.datatime = datatime;
    }

    @Override
    public String toString() {
        return "S_data{" +
                "id=" + id +
                ", devid='" + devid + '\'' +
                ", hum=" + hum +
                ", tem=" + tem +
                ", rain=" + rain +
                ", north='" + north + '\'' +
                ", east='" + east + '\'' +
                ", datatime=" + datatime +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDevid() {
        return devid;
    }

    public void setDevid(String devid) {
        this.devid = devid;
    }

    public float getHum() {
        return hum;
    }

    public void setHum(float hum) {
        this.hum = hum;
    }

    public float getTem() {
        return tem;
    }

    public void setTem(float tem) {
        this.tem = tem;
    }

    public int getRain() {
        return rain;
    }

    public void setRain(int rain) {
        this.rain = rain;
    }

    public String getNorth() {
        return north;
    }

    public void setNorth(String north) {
        this.north = north;
    }

    public String getEast() {
        return east;
    }

    public void setEast(String east) {
        this.east = east;
    }

    public Date getDatatime() {
        return datatime;
    }

    public void setDatatime(Date datatime) {
        this.datatime = datatime;
    }

    public S_data() {
    }
}
