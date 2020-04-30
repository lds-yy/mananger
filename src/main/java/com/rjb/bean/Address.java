package com.rjb.bean;

public class Address {
    private Integer uid;
    private Integer userid;
    private Boolean defaultAddr;
    private String nation;
    private String province;
    private String city;
    private String country;
    private String street;
    private String remark;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getUserid() {
        return userid;
    }

    @Override
    public String toString() {
        return "Address{" +
                "uid=" + uid +
                ", userid=" + userid +
                ", defaultAddr=" + defaultAddr +
                ", nation='" + nation + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", street='" + street + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }

    public Address() {
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Boolean getDefaultAddr() {
        return defaultAddr;
    }

    public void setDefaultAddr(Boolean defaultAddr) {
        this.defaultAddr = defaultAddr;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
