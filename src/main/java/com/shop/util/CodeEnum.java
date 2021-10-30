package com.shop.util;

public enum CodeEnum {
    SUCCESS(200,"成功"),
    FAILD(400,"失败");

    private CodeEnum(int Code, String Desc) {
        this.key = key;
        this.name = name;
    }

    private String key;

    private String name;

    @Override
    public String toString(){
        return key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
