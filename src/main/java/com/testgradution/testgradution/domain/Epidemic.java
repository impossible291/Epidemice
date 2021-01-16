package com.testgradution.testgradution.domain;

/**
 * 疫情上报界面
 * create by 周海强
 */
public class Epidemic {

    //id
    private Integer id;

    //people_id当前用户id
    private Integer peopleId;

    //是否呼吸困难
    private String isDifficultyBreath;

    //是否乏力
    private String isWeak;

    //是否咳嗽
    private  String isCough;

    //体温
    private Double temperature;

    //区域
    private String location;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(Integer peopleId) {
        this.peopleId = peopleId;
    }

    public String getIsDifficultyBreath() {
        return isDifficultyBreath;
    }

    public void setIsDifficultyBreath(String isDifficultyBreath) {
        this.isDifficultyBreath = isDifficultyBreath;
    }

    public String getIsWeak() {
        return isWeak;
    }

    public void setIsWeak(String isWeak) {
        this.isWeak = isWeak;
    }

    public String getIsCough() {
        return isCough;
    }

    public void setIsCough(String isCough) {
        this.isCough = isCough;
    }


    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
