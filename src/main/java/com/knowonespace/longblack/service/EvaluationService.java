package com.knowonespace.longblack.service;

import com.knowonespace.longblack.model.pojo.Evaluation;

import java.util.List;

public interface EvaluationService {
    void evaluate(Long memberId, Long articleId, Integer score, String content);

    List<Evaluation> showAllEvaluation(Long id);
}
