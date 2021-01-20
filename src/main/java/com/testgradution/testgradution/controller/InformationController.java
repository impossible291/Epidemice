package com.testgradution.testgradution.controller;

import com.alibaba.fastjson.JSONObject;
import com.testgradution.testgradution.domain.Information;
import com.testgradution.testgradution.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

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

    /**
     * 根据用户名和发送状态来显示对应的数据
     * @param httpServletRequest
     * @return
     */
    @RequestMapping("/selectByNameAndSendstatus")
    public  Object selectByNameAndSendstatus(HttpServletRequest request,HttpSession session){
        JSONObject jsonObject=new JSONObject();
        //登录成功之后会将用户名给session，此处获取。
        String name=(String) session.getAttribute("username");
        String sendStatus=request.getParameter("sendStatus");
        //调用查询接口
        if(name!=null && sendStatus!=null){
            try{
                List<Information> informationList= informationService.selectByNameAndSendstatus(name,sendStatus);
                if (informationList!=null && informationList.size()!=0){
                    jsonObject.put("code",200);
                    jsonObject.put("msg","查询成功");
                    jsonObject.put("data",informationList);
                }
            }catch (Exception e){
                throw  new RuntimeException(e);
            }
        }else{
            jsonObject.put("code",-999);
            jsonObject.put("msg","查询失败");
        }
        return  jsonObject;
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

