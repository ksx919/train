package com.fanxin.train.common.exception;

public enum BusinessExceptionEnum {

    MEMBER_MOBILE_EXIST("手机号已注册");

    BusinessExceptionEnum(String desc) {
        this.desc = desc;
    }

    private String desc;

    @Override
    public String toString() {
        return "BusinessExceptionEnum{" +
                "desc='" + desc + '\'' +
                '}';
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
