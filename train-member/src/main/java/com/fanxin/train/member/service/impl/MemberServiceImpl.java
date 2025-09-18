package com.fanxin.train.member.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.fanxin.train.common.exception.BusinessException;
import com.fanxin.train.common.exception.BusinessExceptionEnum;
import com.fanxin.train.common.util.SnowUtil;
import com.fanxin.train.member.domain.Member;
import com.fanxin.train.member.domain.MemberExample;
import com.fanxin.train.member.mapper.MemberMapper;
import com.fanxin.train.member.req.MemberRegisterReq;
import com.fanxin.train.member.req.MemberSendCodeReq;
import com.fanxin.train.member.service.MemberService;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    private static final Logger LOG = LoggerFactory.getLogger(MemberServiceImpl.class);

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
        member.setId(SnowUtil.getSnowflakeNextId());
        member.setMobile(mobile);
        memberMapper.insert(member);
        return member.getId();
    }

    @Override
    public void sendCode(MemberSendCodeReq req) {
        String mobile = req.getMobile();
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andMobileEqualTo(mobile);
        List<Member> list = memberMapper.selectByExample(memberExample);

        // 如果手机号不存在
        if (CollUtil.isEmpty(list)){
            LOG.info("手机号不存在，插入一条记录");
            Member member = new Member();
            member.setId(SnowUtil.getSnowflakeNextId());
            member.setMobile(mobile);
            memberMapper.insert(member);
        }else{
            LOG.info("手机号已存在，不插入记录");
        }

        //生成验证码
//        String code = RandomUtil.randomString(4);
        String code = "8888";
        LOG.info("生成短信验证码：{}",code);

        //保存短信记录表：手机号，短信验证码，有效期，是否已使用，业务类型，发送时间，使用时间
        LOG.info("保存短信记录表");

        //对接短信通道，发送短信
        LOG.info("对接短信通道");
    }


}
