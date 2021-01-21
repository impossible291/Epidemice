package com.testgradution.testgradution.service;

import com.testgradution.testgradution.domain.Information;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InformationService {
    //保存信息
    public int saveInformation(Information information);

    //查询信息
    public List<Information> selectByNameAndSendstatus(String name,String sendStatus);

    //更新发送状态字段值为发送
    public void updateSendStatus(Long id);
}
