package com.knowonespace.longblack.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.knowonespace.longblack.exception.LongBlackExceptionEnum;
import com.knowonespace.longblack.exception.LongblackException;
import com.knowonespace.longblack.model.dao.ArticleMapper;
import com.knowonespace.longblack.model.pojo.Article;
import com.knowonespace.longblack.model.req.ArticleReq;
import com.knowonespace.longblack.service.ArticleService;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private ArticleMapper articleMapper;

    public PageInfo showList(ArticleReq articleReq) {

        if (!StringUtils.isNullOrEmpty(articleReq.getArticleKeyWord())) {
            //不为空,拼接关键字,利用数据库的模糊查找功能
            String keyword=new StringBuilder().append("%").append(articleReq.getArticleKeyWord()).append("%").toString();
            articleReq.setArticleKeyWord(keyword);
        }
        PageHelper.startPage(articleReq.getPageNum(), articleReq.getPageSize());
        List<Article> articleList = articleMapper.selectList(articleReq);
        PageInfo pageInfo = new PageInfo(articleList);
        return pageInfo;
    }

    public Article detail(Long id) {
        if (id == null) {
            throw new LongblackException(LongBlackExceptionEnum.PARA_NOT_NULL);
        }
        Article article = articleMapper.selectByPrimaryKey(id);
        if (article == null) {
            throw new LongblackException(LongBlackExceptionEnum.ARTICLE_NOT_EXISTED);
        }
        return article;
    }
}
