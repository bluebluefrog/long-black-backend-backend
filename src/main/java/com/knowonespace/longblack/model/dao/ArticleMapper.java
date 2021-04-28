package com.knowonespace.longblack.model.dao;

import com.knowonespace.longblack.model.pojo.Article;
import com.knowonespace.longblack.model.req.ArticleReq;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleMapper {
    int deleteByPrimaryKey(Long articleId);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Long articleId);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKeyWithBLOBs(Article record);

    int updateByPrimaryKey(Article record);

    List<Article> selectList(@Param("articleReq") ArticleReq articleReq);
}