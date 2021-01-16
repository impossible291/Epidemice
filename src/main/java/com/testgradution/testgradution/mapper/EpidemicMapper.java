package com.testgradution.testgradution.mapper;

import com.testgradution.testgradution.domain.Epidemic;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface EpidemicMapper {
    //保存该用户的信息
    public  int insertEpidemic(Epidemic epidemic);
    //查询所有信息
    public List<Epidemic> selectAll(Integer peopleId);
}
