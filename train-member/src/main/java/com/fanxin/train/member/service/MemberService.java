package com.fanxin.train.member.service;

import com.fanxin.train.member.req.MemberRegisterReq;
import com.fanxin.train.member.req.MemberSendCodeReq;

public interface MemberService {
    int count();

    long register(MemberRegisterReq req);

    void sendCode(MemberSendCodeReq req);
}
