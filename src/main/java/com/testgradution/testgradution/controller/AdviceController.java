package com.testgradution.testgradution.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.testgradution.testgradution.domain.Advice;
import com.testgradution.testgradution.domain.Doctor;
import com.testgradution.testgradution.domain.People;
import com.testgradution.testgradution.mapper.PeopleMapper;
import com.testgradution.testgradution.service.AdviceService;
import com.testgradution.testgradution.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:8080","null"})
@RestController
@RequestMapping("/advice")
public class AdviceController {
    @Autowired
    public DoctorService doctorService;

    @Autowired
    public AdviceService adviceService;

    @Autowired
    public PeopleMapper peopleMapper;

    @RequestMapping("/insertAdvice")
    public  Object insertAdvice(HttpServletRequest httpServletRequest,HttpSession httpSession){
        JSONObject jsonObject=new JSONObject();
        //根据医生的用户名查询出医生信息然后塞建议
        String name=(String) httpSession.getAttribute("username");
        if(name==null){
            jsonObject.put("code",999);
            jsonObject.put("msg","医生用户名为空，请重新登录");
            return jsonObject;
        }
        try{
            Advice advice=setAdvice(httpServletRequest);
            Doctor doctor=doctorService.selectByname(name);
            adviceService.insertAdvice(doctor,advice);
            jsonObject.put("code",200);
            jsonObject.put("msg","发送成功");
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
        return  jsonObject;
    }

    @RequestMapping("/selectByPeople")
    public Object selectByPeople(HttpSession httpSession){
        JSONObject jsonObject=new JSONObject();
        String userName=(String) httpSession.getAttribute("username");
        Long id=peopleMapper.selectByUserName(userName).getId();
        try{
            List<Advice> advice=adviceService.selectByPeople(id);
            jsonObject.put("code",200);
            jsonObject.put("msg","查询成功");
            jsonObject.put("data",advice);
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
        return  jsonObject;
    }
    public Advice setAdvice(HttpServletRequest httpServletRequest){
        Advice advice=new Advice();
        advice.setZl(httpServletRequest.getParameter("zl"));
        advice.setGl(httpServletRequest.getParameter("gl"));
        advice.setYw(httpServletRequest.getParameter("yw"));
        advice.setAdvice(httpServletRequest.getParameter("advice"));
        advice.setPeopleId(Long.valueOf(httpServletRequest.getParameter("peopleId")));
        return  advice;
    }

}
