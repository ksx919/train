package com.fanxin.train.member.service;

import com.fanxin.train.member.req.MemberRegisterReq;

public interface MemberService {
    int count();

    long register(MemberRegisterReq req);
}
