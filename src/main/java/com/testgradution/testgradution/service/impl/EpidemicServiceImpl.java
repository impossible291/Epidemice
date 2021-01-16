package com.testgradution.testgradution.service.impl;

import com.testgradution.testgradution.domain.Epidemic;
import com.testgradution.testgradution.mapper.EpidemicMapper;
import com.testgradution.testgradution.service.EpidemicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EpidemicServiceImpl implements EpidemicService {

    @Autowired
    private EpidemicMapper epidemicMapper;

    @Override
    public int insertEpidemic(Epidemic epidemic) {
        return epidemicMapper.insertEpidemic(epidemic);
    }

    @Override
    public List<Epidemic> selectAll(Integer peopleId) {
        return epidemicMapper.selectAll(peopleId);
    }


}
