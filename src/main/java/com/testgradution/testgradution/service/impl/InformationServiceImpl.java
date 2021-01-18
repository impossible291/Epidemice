package com.testgradution.testgradution.service.impl;

import com.testgradution.testgradution.domain.Information;
import com.testgradution.testgradution.mapper.InformatioMapper;
import com.testgradution.testgradution.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InformationServiceImpl implements InformationService {
    @Autowired
    public InformatioMapper informatioMapper;

    @Override
    public int saveInformation(Information information) {
        return 0;
    }
}
