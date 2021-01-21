package com.testgradution.testgradution.mapper;

import com.testgradution.testgradution.domain.Information;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface InformationMapper {
    //信息录入
    public int saveInformation(Information information);
    //信息查询
    public List<Information> selectByNameAndSendstatus(String name,String sendStatus);

    public void  updateSendStatus(Long id);
}
