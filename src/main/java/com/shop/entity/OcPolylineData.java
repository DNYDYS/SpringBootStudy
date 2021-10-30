package com.shop.entity;

public class OcPolylineData {

    private int id;

    private String polylineName;

    private String polylineType;

    @Override
    public String toString() {
        return "OcPolylineData{" +
            "id=" + id +
            ", polylineName='" + polylineName + '\'' +
            ", polylineType='" + polylineType + '\'' +
            '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPolylineName() {
        return polylineName;
    }

    public void setPolylineName(String polylineName) {
        this.polylineName = polylineName;
    }

    public String getPolylineType() {
        return polylineType;
    }

    public void setPolylineType(String polylineType) {
        this.polylineType = polylineType;
    }
}
