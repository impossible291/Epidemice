package com.testgradution.testgradution.domain;

/**
 * 信息录入实体类
 */
public class Information {
    private  long id;
    //患者id
    private  Long peopleId;
    //用户名
    private String userName;
    //姓名
    private  String name;

    //身份证号
    private  String cardNo;

    //是否咳嗽
    private  String radio;

    //是否胸闷
    private  String sfxm;

    //是否乏力
    private  String sffl;

    //体温
    private  String temperature;

    //所在地区
    private String region;

    //健康状况
    private String healthyStatus;

    //备注
    private String demo;

    //发送状态
    private  String sendStatus;

    //患者头像
    private  String pic;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getRadio() {
        return radio;
    }

    public void setRadio(String radio) {
        this.radio = radio;
    }

    public String getSfxm() {
        return sfxm;
    }

    public void setSfxm(String sfxm) {
        this.sfxm = sfxm;
    }

    public String getSffl() {
        return sffl;
    }

    public void setSffl(String sffl) {
        this.sffl = sffl;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getHealthyStatus() {
        return healthyStatus;
    }

    public void setHealthyStatus(String healthyStatus) {
        this.healthyStatus = healthyStatus;
    }

    public String getDemo() {
        return demo;
    }

    public void setDemo(String demo) {
        this.demo = demo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(String sendStatus) {
        this.sendStatus = sendStatus;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(Long peopleId) {
        this.peopleId = peopleId;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}

