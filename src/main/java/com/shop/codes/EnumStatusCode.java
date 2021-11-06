package com.shop.codes;

public enum EnumStatusCode {
    SUCCESS(200,"成功"),
    FAILD(400,"失败");

    private int code;
    private String desc;

    EnumStatusCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "EnumStatusCode{" +
            "code=" + code +
            ", desc='" + desc + '\'' +
            '}';
    }
}
