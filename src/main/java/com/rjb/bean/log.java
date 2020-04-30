package com.rjb.bean;

import java.util.Date;

public class log {
    private Date oprTime;
    private String type;
    private String operator;
    private String moudle;
    private String opration;
    private String result;

    @Override
    public String toString() {
        return "log{" +
                "oprTime=" + oprTime +
                ", type='" + type + '\'' +
                ", moudle='" + moudle + '\'' +
                ", operator='" + operator + '\'' +
                ", result='" + result + '\'' +
                '}';
    }

    public String getOpration() {
        return opration;
    }

    public void setOpration(String opration) {
        this.opration = opration;
    }

    public Date getOprTime() {
        return oprTime;
    }

    public void setOprTime(Date oprTime) {
        this.oprTime = oprTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMoudle() {
        return moudle;
    }

    public void setMoudle(String moudle) {
        this.moudle = moudle;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public log() {
    }
}
