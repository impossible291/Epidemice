package com.testgradution.testgradution.service;

import com.testgradution.testgradution.domain.Doctor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorService {
    //验证用户名和密码是否正确（登录）
    public  int  doctorLogin(String name,String password);

    //查询所有医生
    public List<Doctor> selectAlls();
}
