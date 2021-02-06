package com.testgradution.testgradution.controller;

import com.alibaba.fastjson.JSONObject;
import com.testgradution.testgradution.domain.Doctor;
import com.testgradution.testgradution.domain.People;
import com.testgradution.testgradution.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:8080", "null"})
@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    public DoctorService doctorService;

    @RequestMapping("/doctorLogin")
    public  Object  loginStatus(HttpServletRequest request, HttpSession session){
        JSONObject jsonObject=new JSONObject();
        String username=request.getParameter("name");
        String password=request.getParameter("password");
        try{
            int ans=doctorService.doctorLogin(username,password);
            if(ans>0){
                jsonObject.put("code",1);
                jsonObject.put("msg","登陆成功");
                session.setAttribute("username",username);
                return jsonObject;
            }else{
                jsonObject.put("code",-1);
                jsonObject.put("msg","用户名或者密码错误");
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return  jsonObject;
    }

    @RequestMapping("/selectAll")
    public Object selectAll(){
        JSONObject jsonObject=new JSONObject();
        try{
            List<Doctor> doctorList=doctorService.selectAlls();
            if(doctorList.size()==0 || doctorList==null){
                jsonObject.put("code",-1);
                jsonObject.put("msg","查询失败");
                return jsonObject;
            }
            jsonObject.put("code",200);
            jsonObject.put("msg","查询所有用户成功");
            jsonObject.put("data",doctorList);
        }catch (Exception e){
            e.printStackTrace();
        }
        return jsonObject;
    }


}
