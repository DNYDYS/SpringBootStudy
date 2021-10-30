package com.shop.entity;


import java.math.BigDecimal;
import java.util.Date;

/**
 * (OcCurrentDayRevenue)实体类
 *
 * @author makejava
 * @since 2021-08-23 16:20:42
 */
public class OcCurrentDayRevenue {

    private int id;

    private float money;

    private int polylineId;

    private Date date;

    @Override
    public String toString() {
        return "OcCurrentDayRevenue{" +
            "id=" + id +
            ", money=" + money +
            ", polylineId=" + polylineId +
            ", date=" + date +
            '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public int getPolylineId() {
        return polylineId;
    }

    public void setPolylineId(int polylineId) {
        this.polylineId = polylineId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
