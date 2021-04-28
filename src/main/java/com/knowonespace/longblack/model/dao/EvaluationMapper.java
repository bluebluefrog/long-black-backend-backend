package com.knowonespace.longblack.model.dao;

import com.knowonespace.longblack.model.pojo.Evaluation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluationMapper {
    int deleteByPrimaryKey(Long evaluationId);

    int insert(Evaluation record);

    int insertSelective(Evaluation record);

    Evaluation selectByPrimaryKey(Long evaluationId);

    int updateByPrimaryKeySelective(Evaluation record);

    int updateByPrimaryKey(Evaluation record);

    List<Evaluation> selectAllEvaluation(@Param("id") Long id);
}