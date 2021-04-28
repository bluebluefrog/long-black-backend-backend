package com.knowonespace.longblack.service.impl;

import com.knowonespace.longblack.exception.LongBlackExceptionEnum;
import com.knowonespace.longblack.exception.LongblackException;
import com.knowonespace.longblack.model.dao.EvaluationMapper;
import com.knowonespace.longblack.model.dao.MemberMapper;
import com.knowonespace.longblack.model.pojo.Evaluation;
import com.knowonespace.longblack.model.pojo.Member;
import com.knowonespace.longblack.service.MemberService;
import com.knowonespace.longblack.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.Date;

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    private MemberMapper memberMapper;

    public void register(String userName, String password) {
        //查询老用户是否存在
        Member oldMember = memberMapper.selectByName(userName);
        if (oldMember != null) {
            throw new LongblackException(LongBlackExceptionEnum.NAME_EXISTED);
        }
        Member member = new Member();
        member.setUsername(userName);
        try {
            member.setPassword(MD5Utils.getMD5Str(password));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        member.setCreateTime(new Date());
        member.setNickname(userName);
        member.setSignature("user haven't write any signature yet");

        int count = memberMapper.insertSelective(member);

        if (count == 0) {
            throw new LongblackException(LongBlackExceptionEnum.INSERT_FAIL);
        }
    }


    public Member login(String userName, String password) {
        Member member = memberMapper.selectByName(userName);
        if (member == null) {
            throw new LongblackException(LongBlackExceptionEnum.USER_NOT_EXISTED);
        }
        String md5pass = null;
        try {
           md5pass = MD5Utils.getMD5Str(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        if (!md5pass.equals(member.getPassword())) {
            throw new LongblackException(LongBlackExceptionEnum.WRONG_PASSWORD);
        }
        return member;
    }
}
