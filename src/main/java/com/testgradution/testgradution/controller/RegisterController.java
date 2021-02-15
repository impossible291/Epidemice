package com.testgradution.testgradution.controller;

import com.alibaba.fastjson.JSONObject;
import com.testgradution.testgradution.domain.Doctor;
import com.testgradution.testgradution.domain.People;
import com.testgradution.testgradution.mapper.PeopleMapper;
import com.testgradution.testgradution.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@CrossOrigin(origins = {"http://localhost:8080", "null"})
@RequestMapping("/register")
@RestController
public class RegisterController {
    @Autowired
    public DoctorService doctorService;

    @Autowired
    public PeopleMapper peopleMapper;
    @RequestMapping("/doctorOrDiease")
    public Object doctorOrDiease(HttpServletRequest httpServletRequest){
        JSONObject jsonObject=new JSONObject();
        //根据注册者的身份进行不同的注册
        if("患者".equals(httpServletRequest.getParameter("role"))){
             People people=setPeoples(httpServletRequest);
             //调用患者注册接口
            int ans=peopleMapper.registerPeople(people);
            if(ans>0){
                jsonObject.put("code",200);
                jsonObject.put("msg","患者注册成功");
                return  jsonObject;
            }
        }else if("医生".equals(httpServletRequest.getParameter("role"))){
             Doctor doctor=setDoctors(httpServletRequest);
             //调用医生注册接口
            int ans=doctorService.registerDoctor(doctor);
            if(ans>0){
                jsonObject.put("code",200);
                jsonObject.put("msg","医生注册成功");
                return jsonObject;
            }
        }
        jsonObject.put("code",999);
        jsonObject.put("msg","注册失败");
        return jsonObject;
    }

    public Doctor setDoctors(HttpServletRequest httpServletRequest){
        Doctor doctor=new Doctor();
        doctor.setUserName(httpServletRequest.getParameter("userName"));
        doctor.setName(httpServletRequest.getParameter("name"));
        doctor.setPassword(httpServletRequest.getParameter("password"));
        doctor.setSex(httpServletRequest.getParameter("sex"));
        doctor.setCardNo(httpServletRequest.getParameter("cardNo"));
        doctor.setEmail(httpServletRequest.getParameter("email"));
        doctor.setHospital(httpServletRequest.getParameter("hospital"));
        doctor.setIdNumber(httpServletRequest.getParameter("idNumber"));
        doctor.setIntroduce(httpServletRequest.getParameter("introduce"));
        doctor.setPhone(httpServletRequest.getParameter("phone"));
        doctor.setAge(Integer.parseInt(httpServletRequest.getParameter("age")));
        doctor.setAddress(httpServletRequest.getParameter("address"));
        return doctor;
    }

    public People setPeoples(HttpServletRequest httpServletRequest){
        People people=new People();
        people.setUserName(httpServletRequest.getParameter("userName"));
        people.setName(httpServletRequest.getParameter("name"));
        people.setPassword(httpServletRequest.getParameter("password"));
        people.setSex(httpServletRequest.getParameter("sex"));
        people.setCardNo(httpServletRequest.getParameter("cardNo"));
        people.setPhone(httpServletRequest.getParameter("phone"));
        people.setAge(Integer.parseInt(httpServletRequest.getParameter("age")));
        people.setLocation(httpServletRequest.getParameter("address"));
        return people;
    }
}
