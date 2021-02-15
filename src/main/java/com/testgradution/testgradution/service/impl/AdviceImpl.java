package com.testgradution.testgradution.service.impl;

import com.testgradution.testgradution.domain.Advice;
import com.testgradution.testgradution.domain.Doctor;
import com.testgradution.testgradution.mapper.AdviceMapper;
import com.testgradution.testgradution.service.AdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdviceImpl  implements AdviceService {
    @Autowired
    public AdviceMapper adviceMapper;
    @Override
    public int insertAdvice(Doctor doctor, Advice advice) {
        if(doctor==null){
            throw  new RuntimeException("拉取医生信息失败");
        }
        Advice advice1=new Advice();
        advice1.setDoctorId(doctor.getId());
        advice1.setDoctorName(doctor.getName());
        advice1.setAge(doctor.getAge());
        advice1.setGl(advice.getGl());
        advice1.setKs(doctor.getKs());
        advice1.setYw(advice.getYw());
        advice1.setZl(advice.getZl());
        advice1.setHospital(doctor.getHospital());
        advice1.setAdvice(advice.getAdvice());
        advice1.setPic(doctor.getPic());
        advice1.setPeopleId(advice.getPeopleId());
        return adviceMapper.insertAdvice(advice1);
    }

    @Override
    public List<Advice> selectByPeople(Long id) {
        return adviceMapper.selectByPeople(id);
    }
}
