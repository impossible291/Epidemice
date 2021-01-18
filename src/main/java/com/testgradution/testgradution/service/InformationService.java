package com.testgradution.testgradution.service;

import com.testgradution.testgradution.domain.Information;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface InformationService {
    //保存信息
    public int saveInformation(Information information);
}
