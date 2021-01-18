package com.testgradution.testgradution.mapper;

import com.testgradution.testgradution.domain.Information;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface InformatioMapper {
    //信息录入
    public int saveInformation(Information information);
}
