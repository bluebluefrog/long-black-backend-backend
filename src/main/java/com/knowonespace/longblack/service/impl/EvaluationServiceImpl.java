package com.knowonespace.longblack.service.impl;

import com.knowonespace.longblack.exception.LongBlackExceptionEnum;
import com.knowonespace.longblack.exception.LongblackException;
import com.knowonespace.longblack.model.dao.EvaluationMapper;
import com.knowonespace.longblack.model.dao.MemberMapper;
import com.knowonespace.longblack.model.pojo.Evaluation;
import com.knowonespace.longblack.model.pojo.Member;
import com.knowonespace.longblack.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EvaluationServiceImpl implements EvaluationService {

    @Autowired
    private EvaluationMapper evaluationMapper;

    @Autowired
    private MemberMapper memberMapper;

    public void evaluate(Long memberId, Long articleId, Integer score, String content) {
        Evaluation evaluation = new Evaluation();
        evaluation.setMemberId(memberId);
        evaluation.setArticleId(articleId);
        evaluation.setScore(score);
        evaluation.setContent(content);
        evaluation.setCreateTime(new Date());
        evaluation.setState("enable");
        evaluation.setEnjoy(0);
        int count = evaluationMapper.insertSelective(evaluation);
        if (count < 1) {
            throw new LongblackException(LongBlackExceptionEnum.EVALUATE_FAIL);
        }
    }


    public List<Evaluation> showAllEvaluation(Long id) {
        if (id == null || id == 0) {
            throw new LongblackException(LongBlackExceptionEnum.PARA_NOT_NULL);
        }
        List<Evaluation> evaluations = evaluationMapper.selectAllEvaluation(id);
        for (Evaluation e:evaluations) {
            Member member = memberMapper.selectByPrimaryKey(e.getMemberId());
            e.setMember(member);
        }
        return evaluations;
    }
}
