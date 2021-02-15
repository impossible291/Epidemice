package com.testgradution.testgradution.domain;

import org.springframework.data.relational.core.mapping.Column;

import java.util.List;

public class Doctor {
    private  long id;
    @Column("user_name")
    private String userName;  //用户名称
    private String name;  //医生姓名
    private String sex;   //性别
    private  String password;  //登录密码
    private int age;   //年龄
    private String hospital;   //所属医院
    @Column("id_number")
    private String idNumber;  //编号
    private  String address;  //地址
    private  String introduce;  //医生简介
    private  String ks;   //科室
    private  String email;  //邮箱
    private List<People> peoples;  //所关联的患者
    @Column("card_no")
    private  String cardNo;  //身份证号
    private  String phone;  //医生手机号码
    private  String pic;   //医生头像
    private  List<Long> peopleIds;  //患者id


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public List<People> getPeoples() {
        return peoples;
    }

    public void setPeoples(List<People> peoples) {
        this.peoples = peoples;
    }

    public String getKs() {
        return ks;
    }

    public void setKs(String ks) {
        this.ks = ks;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public List<Long> getPeopleIds() {
        return peopleIds;
    }

    public void setPeopleIds(List<Long> peopleIds) {
        this.peopleIds = peopleIds;
    }
}
