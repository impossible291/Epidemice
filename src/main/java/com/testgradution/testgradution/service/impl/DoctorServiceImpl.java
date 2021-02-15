package com.testgradution.testgradution.service.impl;

import com.testgradution.testgradution.domain.Doctor;
import com.testgradution.testgradution.domain.DoctorRefPeople;
import com.testgradution.testgradution.mapper.DoctorMapper;
import com.testgradution.testgradution.mapper.DoctorRefPeopleMapper;
import com.testgradution.testgradution.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    public DoctorMapper doctorMapper;

    @Autowired
    public DoctorRefPeopleMapper doctorRefPeopleMapper;

    @Override
    public int doctorLogin(String name, String password) {
        int ans=doctorMapper.doctorLogin(name,password);
        return ans;
    }

    @Override
    public List<Doctor> selectAlls() {
        return doctorMapper.selectAll();
    }

    @Override
    public int registerDoctor(Doctor doctor) {
        return doctorMapper.registerDoctor(doctor);
    }

    @Override
    public List<Doctor> selectByIds(List<Long> ids) {
        if(ids.size()==0 || ids==null){
            throw  new RuntimeException("传入id为空");
        }
        return doctorMapper.selectByIds(ids);
    }

    @Override
    public int ref(DoctorRefPeople doctorRefPeople) {
        if(doctorRefPeople.getDoctorId()==null || doctorRefPeople.getPeopleId()==null){
            throw  new RuntimeException("医生或患者id为空");
        }
        return doctorRefPeopleMapper.ref(doctorRefPeople);
    }

    @Override
    public Doctor selectByname(String username) {
         return doctorMapper.selectByname(username);
    }
}
