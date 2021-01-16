package com.testgradution.testgradution.domain;

public class People {
    //用户id
    private int id;
    //用户名称
    private String name;
    //用户所在区域
    private String location;
    //用户电话
    private String phone;
    //根据该用户输入信息给出的建议
    private String advice;
    //根据该用户输入的信息判断是高、中、低那种风险程度
    private  String risk;
    //用户性别
    private Boolean sex;
    //用户头像字段
    private String pic;
    //用户密码
    private String password;

    //身份证号码
    private  String cardNo;

    //来源地
    private  String source;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocaltion() {
        return location;
    }

    public void setLocaltion(String localtion) {
        this.location = localtion;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    public String getRisk() {
        return risk;
    }

    public void setRisk(String risk) {
        this.risk = risk;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
