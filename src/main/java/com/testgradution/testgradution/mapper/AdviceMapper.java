package com.testgradution.testgradution.mapper;

import com.testgradution.testgradution.domain.Advice;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface AdviceMapper {
    //医生给出患者的意见
    public  int insertAdvice(Advice advice);

    //查询此患者对应的医生给出的建议
    public List<Advice> selectByPeople(Long id);
}
