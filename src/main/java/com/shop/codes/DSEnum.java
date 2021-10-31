package com.shop.codes;

public enum DSEnum {
    DB1("dbcp1"),
    DB2("dbcp2"),
    DB3("dbcp3");

    private String value;

    DSEnum(String value){
        this.value=value;
    }

    public String getValue() {
        return value;
    }
}
