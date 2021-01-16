package com.testgradution.testgradution.service;

import com.testgradution.testgradution.domain.Epidemic;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EpidemicService {
    //保存相关用户信息
    public int insertEpidemic(Epidemic epidemic);
    //查询所有信息
    public List<Epidemic> selectAll(Integer peopleId);
}
