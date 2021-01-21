package com.testgradution.testgradution.service.impl;

import com.testgradution.testgradution.domain.Information;
import com.testgradution.testgradution.mapper.InformationMapper;
import com.testgradution.testgradution.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformationServiceImpl implements InformationService {
    @Autowired
    public InformationMapper informationMapper;

    @Override
    public int saveInformation(Information information) {
        return informationMapper.saveInformation(information);
    }

    @Override
    public List<Information> selectByNameAndSendstatus(String name, String sendStatus) {
        return informationMapper.selectByNameAndSendstatus(name,sendStatus);
    }

    @Override
    public void updateSendStatus(Long id) {
        informationMapper.updateSendStatus(id);
    }
}
