package com.testgradution.testgradution.service.impl;

import com.testgradution.testgradution.domain.DoctorRefPeople;
import com.testgradution.testgradution.mapper.DoctorRefPeopleMapper;
import com.testgradution.testgradution.service.DoctorRefPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorRefPeopleImpl implements DoctorRefPeopleService {
    @Autowired
    public DoctorRefPeopleMapper doctorRefPeopleMapper;
    @Override
    public int ref(DoctorRefPeople doctorRefPeople) {
        if(doctorRefPeople.getDoctorId()==null || doctorRefPeople.getPeopleId()==null){
            throw  new RuntimeException("医生或患者id为空");
        }
        return doctorRefPeopleMapper.ref(doctorRefPeople);
    }
}
