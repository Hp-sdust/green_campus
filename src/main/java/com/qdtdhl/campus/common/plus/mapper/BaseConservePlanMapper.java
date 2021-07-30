package com.qdtdhl.campus.common.plus.mapper;

import com.qdtdhl.campus.common.plus.entity.BaseConservePlan;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface BaseConservePlanMapper extends BaseMapper<BaseConservePlan> {
    List<BaseConservePlan> selectConserveType();
}
