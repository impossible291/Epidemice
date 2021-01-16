package com.testgradution.testgradution.domain;

/**
 * 对应建议表
 */
public class Advice {
    //id
    private Integer id;

    //对应疫情表id
    private Integer epidemiceId;

    //温度对应的意见
    private String temperatureAdvice;

    //区域对应的意见
    private String locationAdvice;

    public Integer getEpidemiceId() {
        return epidemiceId;
    }

    public void setEpidemiceId(Integer epidemiceId) {
        this.epidemiceId = epidemiceId;
    }

    public String getTemperatureAdvice() {
        return temperatureAdvice;
    }

    public void setTemperatureAdvice(String temperatureAdvice) {
        this.temperatureAdvice = temperatureAdvice;
    }

    public String getLocationAdvice() {
        return locationAdvice;
    }

    public void setLocationAdvice(String locationAdvice) {
        this.locationAdvice = locationAdvice;
    }
}
