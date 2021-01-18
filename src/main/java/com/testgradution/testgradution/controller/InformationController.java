package com.testgradution.testgradution.controller;

import com.alibaba.fastjson.JSONObject;
import com.testgradution.testgradution.domain.Information;
import com.testgradution.testgradution.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@CrossOrigin(origins = {"http://localhost:8080", "null"})
@RestController
@RequestMapping("/information")
public class InformationController {
    @Autowired
    public InformationService informationService;

    @RequestMapping(value = "/saveInformation")
    public Object saveInformation(HttpServletRequest httpServletRequest){
        Information information=setInformation(httpServletRequest);
        JSONObject jsonObject=new JSONObject();
        try{
            int ans=informationService.saveInformation(information);
            if(ans>0){
                jsonObject.put("code",200);
                jsonObject.put("msg","信息录入成功");
            }else {
                jsonObject.put("code",-1);
                jsonObject.put("msg","信息录入失败");
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return jsonObject;
    }

    public Information setInformation(HttpServletRequest httpServletRequest){
        Information information=new Information();
        information.setCardNo(httpServletRequest.getParameter("cardNo"));
        information.setDemo(httpServletRequest.getParameter("demo"));
        information.setHealthyStatus(httpServletRequest.getParameter("healthyStatus"));
        information.setName(httpServletRequest.getParameter("name"));
        information.setRadio(httpServletRequest.getParameter("radio"));
        information.setSffl(httpServletRequest.getParameter("sffl"));
        information.setSfxm(httpServletRequest.getParameter("sfxm"));
        information.setTemperature(httpServletRequest.getParameter("temperature"));
        return  information;
    }
}

