package com.testgradution.testgradution.controller;

import com.alibaba.fastjson.JSONObject;
import com.testgradution.testgradution.domain.Admin;
import com.testgradution.testgradution.domain.People;
import com.testgradution.testgradution.mapper.AdminMapper;
import com.testgradution.testgradution.mapper.PeopleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = {"http://localhost:8080", "null"})
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    public AdminMapper adminMapper;
    @Autowired
    public PeopleMapper peopleMapper;


    @RequestMapping("/insertAdmin")
    public boolean  inserAdmin(@RequestBody Admin admin){
        boolean flag=false;
        /**
         * 写一个查询语句来判断此账号是否已经存在
         */
        String name=adminMapper.selectName(admin.getName());
        if(name==null){
            int ans=adminMapper.insertAdmin(admin);
            if(ans>0){
                flag=true;
            }
        }else{
            throw  new RuntimeException("此用户已经存在");
        }
        return flag;
    }

    @RequestMapping(value = "/loginStatus",method = RequestMethod.POST)
    /**
     * 判断是否登陆成功
     */
    public  Object  loginStatus(HttpServletRequest request, HttpSession session){
        JSONObject jsonObject=new JSONObject();
        boolean flag=false;
        String username=request.getParameter("name");
        String password=request.getParameter("password");
        String name=adminMapper.selectName(username);
        if(name==null){
            jsonObject.put("code",999);
            jsonObject.put("msg","用户名不存在");
            return jsonObject;
        }else{
            int ans=adminMapper.passIstrue(username,password);
            if(ans>=1){
                flag=true;
            }
            if(flag){
                jsonObject.put("code",1);
                jsonObject.put("msg","登陆成功");
                session.setAttribute("username",username);
                return jsonObject;
            }else{
                jsonObject.put("code",-1);
                jsonObject.put("msg","用户名或者密码错误");
            }
        }
        return  jsonObject;
    }

    @RequestMapping("/selectAll")
    public Object selectAll(){
        JSONObject jsonObject=new JSONObject();
        try{
            List<People> peopleList=peopleMapper.selectAll();
            if(peopleList.size()==0 || peopleList==null){
                jsonObject.put("code",-1);
                jsonObject.put("msg","查询失败");
                return jsonObject;
            }
            jsonObject.put("code",200);
            jsonObject.put("msg","查询所有用户成功");
            jsonObject.put("data",peopleList);
        }catch (Exception e){
            e.printStackTrace();
        }
        return jsonObject;
    }

}
