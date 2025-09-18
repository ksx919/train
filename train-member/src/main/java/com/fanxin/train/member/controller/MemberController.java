package com.fanxin.train.member.controller;

import com.fanxin.train.common.resp.CommonResp;
import com.fanxin.train.member.req.MemberLoginReq;
import com.fanxin.train.member.req.MemberRegisterReq;
import com.fanxin.train.member.req.MemberSendCodeReq;
import com.fanxin.train.member.resp.MemberLoginResp;
import com.fanxin.train.member.service.MemberService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Resource
    private MemberService memberService;

    @GetMapping("/count")
    public CommonResp<Integer> count(){
        int count = memberService.count();
        return new CommonResp<>(count);
    }

    @PostMapping("/register")
    public CommonResp<Long> register(@Valid @RequestBody MemberRegisterReq req){
        long register = memberService.register(req);
        return new CommonResp<>(register);
    }

    @PostMapping("/send-code")
    public CommonResp<Long> sendCode(@Valid @RequestBody MemberSendCodeReq req){
        memberService.sendCode(req);
        return new CommonResp<>();
    }

    @PostMapping("/login")
    public CommonResp<MemberLoginResp> login(@Valid  @RequestBody MemberLoginReq req){
        return new CommonResp<>(memberService.login(req));
    }
}
