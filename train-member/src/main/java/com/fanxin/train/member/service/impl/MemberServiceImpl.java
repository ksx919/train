package com.fanxin.train.member.service.impl;

import com.fanxin.train.member.mapper.MemberMapper;
import com.fanxin.train.member.service.MemberService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Resource
    private MemberMapper memberMapper;

    @Override
    public int count() {
        return memberMapper.count();
    }
}
