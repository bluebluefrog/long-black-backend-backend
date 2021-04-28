package com.knowonespace.longblack.model.req;

public class ArticleReq {

    private String articleKeyWord;

    private Long categoryId;

    private Integer pageNum = 1;

    private Integer pageSize = 10;


    public String getArticleKeyWord() {
        return articleKeyWord;
    }

    public void setArticleKeyWord(String articleKeyWord) {
        this.articleKeyWord = articleKeyWord;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}