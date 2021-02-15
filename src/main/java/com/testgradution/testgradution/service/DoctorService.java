package com.testgradution.testgradution.service;

import com.testgradution.testgradution.domain.Doctor;
import com.testgradution.testgradution.domain.DoctorRefPeople;
import org.springframework.stereotype.Repository;

import javax.print.Doc;
import java.util.List;

@Repository
public interface DoctorService {
    //验证用户名和密码是否正确（登录）
    public  int  doctorLogin(String name,String password);

    //查询所有医生
    public List<Doctor> selectAlls();

    //医生注册
    public  int registerDoctor(Doctor doctor);

    //批量查询
    public  List<Doctor> selectByIds(List<Long> ids);

    //新建对应关系
    public  int ref(DoctorRefPeople doctorRefPeople) ;

    //根据用户名查询出医生id，用户名不能够重复
    public  Doctor selectByname(String username);
}
