package com.knowonespace.longblack.controller;

import com.github.pagehelper.PageInfo;
import com.knowonespace.longblack.common.ApiRestResponse;
import com.knowonespace.longblack.model.pojo.Article;
import com.knowonespace.longblack.model.pojo.Evaluation;
import com.knowonespace.longblack.model.req.ArticleReq;
import com.knowonespace.longblack.model.vo.ArticleVo;
import com.knowonespace.longblack.service.ArticleService;
import com.knowonespace.longblack.service.EvaluationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private EvaluationService evaluationService;

    @GetMapping("/list")
    public ApiRestResponse list(ArticleReq articleReq) {
        PageInfo list = articleService.showList(articleReq);
        return ApiRestResponse.success(list);
    }

    @GetMapping("/detail")
    public ApiRestResponse list(Long id) {
        Article article = articleService.detail(id);
        List<Evaluation> evaluations = evaluationService.showAllEvaluation(id);
        ArticleVo articleVo = new ArticleVo();
        BeanUtils.copyProperties(article, articleVo);
        articleVo.setEvaluationList(evaluations);
        return ApiRestResponse.success(articleVo);
    }
}
