package com.testgradution.testgradution.mapper;

import com.testgradution.testgradution.domain.Doctor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DoctorMapper {
    public int doctorLogin(String name,String password);

    public List<Doctor> selectAll();

}
