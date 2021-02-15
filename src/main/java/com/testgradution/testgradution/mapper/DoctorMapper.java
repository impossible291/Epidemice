package com.testgradution.testgradution.mapper;

import com.testgradution.testgradution.domain.Doctor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import javax.print.Doc;
import java.util.List;

@Repository
@Mapper
public interface DoctorMapper {
    public int doctorLogin(String name,String password);

    public List<Doctor> selectAll();

    public  int registerDoctor(Doctor doctor);

    public  List<Doctor> selectByIds(List<Long> ids);

    public  Doctor selectByname(String username);

}
