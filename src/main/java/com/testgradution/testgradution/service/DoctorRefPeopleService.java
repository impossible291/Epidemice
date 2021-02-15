package com.testgradution.testgradution.service;

import com.testgradution.testgradution.domain.DoctorRefPeople;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRefPeopleService {
    //新建对应关系
    public  int ref(DoctorRefPeople doctorRefPeople) ;
}
