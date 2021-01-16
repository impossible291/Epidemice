package com.testgradution.testgradution.mapper;

import com.testgradution.testgradution.domain.People;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
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
    public List<People> selectPeoples(List<Integer> ids);

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

}
