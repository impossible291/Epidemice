package com.testgradution.testgradution.controller;

import com.alibaba.fastjson.JSONObject;
import com.testgradution.testgradution.domain.People;
import com.testgradution.testgradution.mapper.PeopleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = {"http://localhost:8080"},allowedHeaders ="*")
@RestController
@RequestMapping("/people")
public class PeopleController {
    @Autowired
    public PeopleMapper peopleMapper;

    /**
     * 查询所有用户
     * @return
     */

    @RequestMapping("/selectAll")
    public Object selectAll(){
        return peopleMapper.selectAll();
    }

    @RequestMapping("/selectAllPeople")
    public Object selectAllPeople(){
        return peopleMapper.selectAll();
    }
    @RequestMapping(value = "/addPeople",method = RequestMethod.POST)
    public Object addPeople(HttpServletRequest request){
        JSONObject jsonObject=new JSONObject();
        //调用插入值的接口
        People people=setPeople(request);
        try{
            int ans=peopleMapper.addPeople(people);
            if(ans>0){
                jsonObject.put("code",200);
                jsonObject.put("msg","添加用户成功");
            }else{
                jsonObject.put("code",-1);
                jsonObject.put("msg","添加用户失败");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return jsonObject;
    }

    /**
     * 根据id查询出对应的用户的信息
     * @return
     */
    @RequestMapping(value = "/selectByPrimaryKey",method = RequestMethod.GET)
    public Object selectByPrimaryKey(HttpServletRequest request){
        Long id=Long.parseLong(request.getParameter("id").trim());
        JSONObject jsonObject=new JSONObject();
        if(id==null){
            jsonObject.put("code",-1);
            jsonObject.put("msg","传入用户id为空");
            return  jsonObject;
        }
        try{
            People peoples=peopleMapper.selectByPrimaryKey(id);
            if(peoples==null){
                jsonObject.put("code","-2");
                jsonObject.put("msg","不存在此用户");
            }
            jsonObject.put("code","200");
            jsonObject.put("msg","查询成功");
            jsonObject.put("data",peoples);
        }catch (Exception e){

        }
        return  jsonObject;
    }

    /**
     * 模糊查询，根据用户姓名模糊查询
     */
    @RequestMapping(value = "selectByName",method = RequestMethod.GET)
    public Object selectByName(HttpServletRequest request){
        JSONObject jsonObject=new JSONObject();
        String name=request.getParameter("name");
        if(name==null || name.length()==0){
            jsonObject.put("code","-1");
            jsonObject.put("msg","用户名为空，查询失败");
            return jsonObject;
        }
        try{
            List<People> people=peopleMapper.selectByName(name);
            if(people.size()==0 || people==null){
                jsonObject.put("code","100");
                jsonObject.put("msg","不存在相关的用户");
                return jsonObject;
            }
            jsonObject.put("code",200);
            jsonObject.put("msg","查询成功");
            jsonObject.put("data",people);
        }catch (Exception e){
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 分页查询
     */
    @RequestMapping("/selectByLimit")
    public  Object selectByLimit(@RequestBody Map map){
        if(!map.containsKey("pageSize")){
            map.put("pageSize",10);
        }
        if(!map.containsKey("pageIndex")){
            map.put("pageIndex",1);
        }
        return "测试";
    }

    /**
     * 删除用户
     */
    @RequestMapping(value = "/deletePeople",method = RequestMethod.GET)
    public  Object deletePeople(Long id){
        JSONObject jsonObject=new JSONObject();
        if(id==null){
            jsonObject.put("code",-1);
            jsonObject.put("msg","传入id为空");
            return jsonObject;
        }
        try{
            int ans=peopleMapper.deletePeople(id);
            if(ans>0){
                jsonObject.put("code",200);
                jsonObject.put("msg","删除成功");
                return jsonObject;
            }else{
                jsonObject.put("code",-2);
                jsonObject.put("msg","删除失败");
                return jsonObject;
            }
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
    }

    @RequestMapping("/updatePeople")
    public Object updatePeople(HttpServletRequest request){
        JSONObject jsonObject=new JSONObject();
        //调用插入值的接口
        People people=setPeople(request);
        try{
            int ans=peopleMapper.updatePeople(people);
            if(ans>0){
                jsonObject.put("code",200);
                jsonObject.put("msg","更新用户信息成功");
            }else{
                jsonObject.put("code",-1);
                jsonObject.put("msg","更新用户信息失败");
                return jsonObject;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
       return  jsonObject;
    }

    /**
     * 批量删除
     * @return
     */
    @RequestMapping(value = "/deleteAll",method = RequestMethod.POST)
    public  Object deleteAll(@RequestBody List<Long> ids){
        JSONObject jsonObject=new JSONObject();
        try{
            int ans=peopleMapper.deleteAll();
            if(ans>0){
                jsonObject.put("code",200);
                jsonObject.put("msg","删除成功");
                return jsonObject;
            }else{
                jsonObject.put("code",200);
                jsonObject.put("msg","删除成功");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  jsonObject;
    }

    public People setPeople(HttpServletRequest request){
        People people=new People();
        if(request.getParameter("id")!=null){people.setId(Integer.parseInt(request.getParameter("id")));}
        if(request.getParameter("cardNo").length()!=18){
            throw  new RuntimeException("身份证号位数不对，请检查！");
        }else{
            people.setCardNo(request.getParameter("cardNo"));
        }
        people.setSource(request.getParameter("source"));
        people.setName(request.getParameter("name").trim());
        people.setSex(Boolean.parseBoolean(request.getParameter("sex").trim()));
        people.setAdvice(request.getParameter("advice").trim());
        people.setLocaltion(request.getParameter("location").trim());
        people.setPassword(request.getParameter("password").trim());
        people.setPhone(request.getParameter("phone").trim());
        people.setRisk(request.getParameter("risk").trim());
        people.setPic(request.getParameter("pic").trim());
        return people;
    }

}
