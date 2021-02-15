package com.testgradution.testgradution.mapper;

import com.testgradution.testgradution.domain.People;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

@Repository
@Mapper
public interface PeopleMapper {
    //新增一个用户
    public int addPeople(People people);

    //删除此用户
    public int deletePeople(Long id);

    //根据主键查询用户相关信息
    public People selectByPrimaryKey(Long id);

    //查询所有用户
    public List<People> selectPeoples(List<Long> ids);

    //根据用户名字模糊查询
    public  List<People> selectByName(String name);

    //分页查询
    public List<People> selectByLimit();

    //更新用户
    public int updatePeople(People  people);

    //查询所有用户
    public List<People> selectAll();

    //删除选中用户
    public  int deleteAll();

    //验证用户是否存在
    public String selectName(String name);

    //验证用户密码是否正确
    public  int passIstrue(String username,String password);

    //修改患者密码
    public  int changePassword(String password);

    //查询旧密码
    public  String selectPassword(String name);

    //更改图片
    public int updatePic(String path,int id);

    //患者注册
    public  int registerPeople(People people);

    //根据患者用户名查询用户信息（用户名不能够重复）
    public People selectByUserName(String userName);

    //查询发送给医生信息的患者
    public  List<Long>   selectDiease(Long id);

}
