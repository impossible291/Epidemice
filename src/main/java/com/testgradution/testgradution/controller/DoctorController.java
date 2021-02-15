package com.testgradution.testgradution.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.testgradution.testgradution.domain.Doctor;
import com.testgradution.testgradution.domain.Information;
import com.testgradution.testgradution.domain.People;
import com.testgradution.testgradution.mapper.PeopleMapper;
import com.testgradution.testgradution.service.DoctorService;
import com.testgradution.testgradution.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.print.Doc;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:8080", "null"})
@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    public DoctorService doctorService;

    @Autowired
    public PeopleMapper peopleMapper;

    @Autowired
    public InformationService informationService;

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
            }else{
                for (Doctor doctor:doctorList){
                    if (doctor.getPeopleIds()==null){
                        continue;
                    }else {
                        //根据患者id批量查询出患者信息，并给医生
                        List<People> peopleList=peopleMapper.selectPeoples(doctor.getPeopleIds());
                        doctor.setPeoples(peopleList);
                    }
                }
            }
            jsonObject.put("code",200);
            jsonObject.put("msg","查询所有用户成功");
            jsonObject.put("data",doctorList);
        }catch (Exception e){
            e.printStackTrace();
        }
        return jsonObject;
    }

    @RequestMapping("/selectDiease")
    public JSONObject  selectDiease(HttpSession httpSession){
        //select * from people where id in(select people_id where id=#{id})
        String   username=(String) httpSession.getAttribute("username");
        //根据用户名查询id，用户名不能够重复
        Doctor doctor=doctorService.selectByname(username);
        Long id=doctor.getId();
        JSONObject jsonObject=new JSONObject();
        if(id==null){
            jsonObject.put("code",999);
            jsonObject.put("msg","输入id为空");
            return jsonObject;
        }
        //调用查询接口
        try {
            List<Information> informationList=informationService.selectDiease(id);
            jsonObject.put("code",200);
            jsonObject.put("msg","查询成功");
            jsonObject.put("data",informationList);
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
        return  jsonObject;
    }
}
