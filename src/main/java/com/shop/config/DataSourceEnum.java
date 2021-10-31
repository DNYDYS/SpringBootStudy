package com.shop.config;

public enum DataSourceEnum {
    DB1("db1"),
    DB2("dbcp2");
//    DB3("dbcp3");

    private String value;

    DataSourceEnum(String value){
        this.value=value;
    }

    public String getValue() {
        return value;
    }
}
