package com.knowonespace.longblack.service;

import com.knowonespace.longblack.model.pojo.Member;

public interface MemberService{

    void register(String userName, String password);

    Member login(String userName, String password);
}
