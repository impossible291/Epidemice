package com.testgradution.testgradution.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.testgradution.testgradution.domain.Doctor;
import com.testgradution.testgradution.domain.DoctorRefPeople;
import com.testgradution.testgradution.domain.Information;
import com.testgradution.testgradution.domain.People;
import com.testgradution.testgradution.mapper.PeopleMapper;
import com.testgradution.testgradution.service.DoctorRefPeopleService;
import com.testgradution.testgradution.service.DoctorService;
import com.testgradution.testgradution.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:8080", "null"})
@RestController
@RequestMapping("/information")
public class InformationController {
    @Autowired
    public InformationService informationService;

    @Autowired
    public PeopleMapper peopleMapper;

    @Autowired
    public DoctorService doctorService;

    @RequestMapping(value = "/saveInformation")
    public Object saveInformation(HttpServletRequest httpServletRequest,HttpSession session){
        Information information=setInformation(httpServletRequest);
        information.setUserName((String) session.getAttribute("username"));
        People people=peopleMapper.selectByUserName((String) session.getAttribute("username"));
        information.setPeopleId(people.getId());
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

    /**
     * 更新发送状态,点击发送之后更新发送状态为1
     * 并要将其信息发送给医生
     * @return
     */
    @RequestMapping(value = "/updateSendStatus",method = RequestMethod.POST)
    public  JSONObject updateSendStatus(@RequestParam("id") Long id,@RequestParam("peopleId") Long peopleId,@RequestParam("ids") List<Long> ids){
        JSONObject jsonObject=new JSONObject();
        try {
            if(ids==null){
                throw new RuntimeException("传入id为空");
            }
            List<Long> userIds=new ArrayList<>();
            userIds.add(peopleId);
            //塞给每个医生,根据传进来的id查询出对应的医生信息
            List<Doctor> doctorList=doctorService.selectByIds(ids);
            for (Doctor doctor:doctorList){
                //给每个医生塞入患者的id，然后根据患者id再进行查询患者信息，进行设置患者信息
                DoctorRefPeople doctorRefPeople=new DoctorRefPeople();
                doctorRefPeople.setDoctorId(doctor.getId());
                doctorRefPeople.setPeopleId(peopleId);
                doctorService.ref(doctorRefPeople);
            }
            //因为患者和医生是多对多的关系，所以建立第三张表进行关联，存放此表主键id，患者id和对应的医生id

            informationService.updateSendStatus(id);
            jsonObject.put("code",200);
            jsonObject.put("msg","发送成功");
        }catch (Exception e){
            throw new RuntimeException(e);
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
        information.setSendStatus(httpServletRequest.getParameter("sendStatus"));
        return  information;
    }
}

