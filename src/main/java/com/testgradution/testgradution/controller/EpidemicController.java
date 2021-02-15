package com.testgradution.testgradution.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.testgradution.testgradution.domain.Advice;
import com.testgradution.testgradution.domain.Epidemic;
import com.testgradution.testgradution.service.EpidemicService;
import org.springframework.aop.AfterAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:8080", "null"})
@RestController
@RequestMapping("/epidemice")
public class EpidemicController {
    @Autowired
    private EpidemicService epidemicService;

    @RequestMapping(value = "/insertEpidemic",method = RequestMethod.POST)
    public  Object  insertEpidemic(HttpServletRequest request){
        JSONObject jsonObject=new JSONObject();
        Epidemic epidemic=generateEpidemic(request);
        Advice advice=new Advice();
        try{
            int ans=epidemicService.insertEpidemic(epidemic);
            //调用查询接口，根据查询出来的值给出对应的意见


            if(ans>0){
                jsonObject.put("code",200);
                jsonObject.put("msg","上报成功");
                return jsonObject;
            }
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
        jsonObject.put("code",999);
        jsonObject.put("msg","信息保存失败");
        return jsonObject;
    }

    /**
     *
     * @param request
     * @return
     */
    @RequestMapping("/selectAll")
    public Object selectAll(@RequestParam("peopleId") Integer peopleId){
        JSONObject jsonObject=new JSONObject();
        if(peopleId==0 || peopleId==-1){
            jsonObject.put("code",-1);
            jsonObject.put("msg","id有误");
            return jsonObject;
        }
        List<Epidemic> epidemic=epidemicService.selectAll(peopleId);
        return  epidemic;
    }

    public Epidemic generateEpidemic(HttpServletRequest request){
        Epidemic epidemic=new Epidemic();
        if(request.getParameter("id")!=null){
            epidemic.setId(Integer.valueOf(request.getParameter("id")));
        }
        if(request.getParameter("peopleId")!=null){
            epidemic.setPeopleId(Integer.valueOf(request.getParameter("peopleId")));
        }
        epidemic.setIsCough(request.getParameter("isCough"));
        epidemic.setIsWeak(request.getParameter("isWeak"));
        epidemic.setIsDifficultyBreath(request.getParameter("isDiffcultyBreath"));
        epidemic.setLocation(request.getParameter("location"));
        epidemic.setTemperature(Double.valueOf(request.getParameter("temperature")));
        return epidemic;
    }

}
