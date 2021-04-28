package com.knowonespace.longblack.service;

import com.github.pagehelper.PageInfo;
import com.knowonespace.longblack.model.pojo.Article;
import com.knowonespace.longblack.model.req.ArticleReq;

public interface ArticleService {

    PageInfo showList(ArticleReq articleReq);

    Article detail(Long id);
}
