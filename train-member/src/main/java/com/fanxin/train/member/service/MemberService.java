package com.fanxin.train.member.service;

import com.fanxin.train.member.req.MemberLoginReq;
import com.fanxin.train.member.req.MemberRegisterReq;
import com.fanxin.train.member.req.MemberSendCodeReq;
import com.fanxin.train.member.resp.MemberLoginResp;

public interface MemberService {
    int count();

    long register(MemberRegisterReq req);

    void sendCode(MemberSendCodeReq req);

    MemberLoginResp login(MemberLoginReq req);
}
