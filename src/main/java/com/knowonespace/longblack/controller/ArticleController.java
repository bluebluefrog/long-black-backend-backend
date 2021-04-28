package com.knowonespace.longblack.controller;

import com.github.pagehelper.PageInfo;
import com.knowonespace.longblack.Common.ApiRestResponse;
import com.knowonespace.longblack.model.pojo.Article;
import com.knowonespace.longblack.model.req.ArticleReq;
import com.knowonespace.longblack.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/list")
    public ApiRestResponse list(ArticleReq articleReq) {
        PageInfo list = articleService.showList(articleReq);
        return ApiRestResponse.success(list);
    }

    @GetMapping("/detail")
    public ApiRestResponse list(@RequestParam Long id) {
        Article article = articleService.detail(id);
        return ApiRestResponse.success(article);
    }
}
