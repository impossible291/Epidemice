package com.testgradution.testgradution.mapper;

import com.testgradution.testgradution.domain.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AdminMapper {
    //新增管理员
    public int insertAdmin(Admin admin);
    //查询管理员名称，防止管理员已存在
    public String selectName(String name);
    //验证密码是否正确的方法
    public int passIstrue(String username,String password);
}
