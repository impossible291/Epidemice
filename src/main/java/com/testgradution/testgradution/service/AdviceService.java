package com.testgradution.testgradution.service;


import com.testgradution.testgradution.domain.Advice;
import com.testgradution.testgradution.domain.Doctor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdviceService {
    //给患者发送建议
    public int insertAdvice(Doctor doctor,Advice advice);

    //查询医生给患者的建议
    public List<Advice>  selectByPeople(Long id);
}
