package com.testgradution.testgradution.domain;

/**
 * 对应建议表
 */
public class Advice {
    //id
    private Integer id;

    //患者id
    private  Long peopleId;

    //医生id
    private  Long doctorId;

    //医生姓名
    private  String doctorName;

    //医生年龄
    private  int age;

    //医生科室
    private String ks;

    //医生所在医院
    private String hospital;

    //对应疫情表id
    private Integer epidemiceId;

    //是否居家隔离
    private String  gl;

    //去医院就诊
    private  String zl;

    //是否需要药物治疗
    private  String yw;

    //医生头像
    private  String pic;

    //区域对应的意见
    private String locationAdvice;

    //给出的意见
    private  String advice;

    public Integer getEpidemiceId() {
        return epidemiceId;
    }

    public void setEpidemiceId(Integer epidemiceId) {
        this.epidemiceId = epidemiceId;
    }


    public String getLocationAdvice() {
        return locationAdvice;
    }

    public void setLocationAdvice(String locationAdvice) {
        this.locationAdvice = locationAdvice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getKs() {
        return ks;
    }

    public void setKs(String ks) {
        this.ks = ks;
    }

    public String getGl() {
        return gl;
    }

    public void setGl(String gl) {
        this.gl = gl;
    }

    public String getZl() {
        return zl;
    }

    public void setZl(String zl) {
        this.zl = zl;
    }

    public String getYw() {
        return yw;
    }

    public void setYw(String yw) {
        this.yw = yw;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Long getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(Long peopleId) {
        this.peopleId = peopleId;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }
}
