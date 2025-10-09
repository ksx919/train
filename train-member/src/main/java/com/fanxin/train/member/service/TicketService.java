package com.fanxin.train.member.service;

import com.fanxin.train.common.req.MemberTicketReq;
import com.fanxin.train.common.resp.PageResp;
import com.fanxin.train.member.req.TicketQueryReq;
import com.fanxin.train.member.resp.TicketQueryResp;

public interface TicketService {

    void save(MemberTicketReq req) throws Exception;

    PageResp<TicketQueryResp> queryList(TicketQueryReq req);

    void delete(Long id);
}