package com.knowonespace.longblack.model.dao;

import com.knowonespace.longblack.model.pojo.MemberReadState;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberReadStateMapper {
    int deleteByPrimaryKey(Long rsId);

    int insert(MemberReadState record);

    int insertSelective(MemberReadState record);

    MemberReadState selectByPrimaryKey(Long rsId);

    int updateByPrimaryKeySelective(MemberReadState record);

    int updateByPrimaryKey(MemberReadState record);
}