package com.testgradution.testgradution.service.impl;

import com.testgradution.testgradution.domain.Doctor;
import com.testgradution.testgradution.mapper.DoctorMapper;
import com.testgradution.testgradution.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    public DoctorMapper doctorMapper;

    @Override
    public int doctorLogin(String name, String password) {
        int ans=doctorMapper.doctorLogin(name,password);
        return ans;
    }

    @Override
    public List<Doctor> selectAlls() {
        return doctorMapper.selectAll();
    }
}
