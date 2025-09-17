package com.fanxin.train.member.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.fanxin.train.common.exception.BusinessException;
import com.fanxin.train.common.exception.BusinessExceptionEnum;
import com.fanxin.train.member.domain.Member;
import com.fanxin.train.member.domain.MemberExample;
import com.fanxin.train.member.mapper.MemberMapper;
import com.fanxin.train.member.req.MemberRegisterReq;
import com.fanxin.train.member.service.MemberService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Resource
    private MemberMapper memberMapper;

    @Override
    public int count() {
        return Math.toIntExact(memberMapper.countByExample(null));
    }

    @Override
    public long register(MemberRegisterReq req) {
        String mobile = req.getMobile();
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andMobileEqualTo(mobile);
        List<Member> list = memberMapper.selectByExample(memberExample);

        if(CollUtil.isNotEmpty(list)){
            throw new BusinessException(BusinessExceptionEnum.MEMBER_MOBILE_EXIST);
        }

        Member member = new Member();
        member.setId(System.currentTimeMillis());
        member.setMobile(mobile);
        memberMapper.insert(member);
        return member.getId();
    }


}
