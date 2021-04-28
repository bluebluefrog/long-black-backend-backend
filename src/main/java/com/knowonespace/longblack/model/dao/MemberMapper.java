package com.knowonespace.longblack.model.dao;

import com.knowonespace.longblack.model.pojo.Member;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberMapper {
    int deleteByPrimaryKey(Long memberId);

    int insert(Member record);

    int insertSelective(Member record);

    Member selectByPrimaryKey(Long memberId);

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);

    Member selectByName(String username);
}