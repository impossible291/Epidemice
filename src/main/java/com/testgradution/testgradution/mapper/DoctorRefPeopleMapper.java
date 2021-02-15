package com.testgradution.testgradution.mapper;

import com.testgradution.testgradution.domain.DoctorRefPeople;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface DoctorRefPeopleMapper {
    //新增对应关系
    public int ref(DoctorRefPeople doctorRefPeople);
}
