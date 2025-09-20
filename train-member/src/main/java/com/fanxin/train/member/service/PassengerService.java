package com.fanxin.train.member.service;

import com.fanxin.train.common.resp.PageResp;
import com.fanxin.train.member.req.PassengerQueryReq;
import com.fanxin.train.member.req.PassengerSaveReq;
import com.fanxin.train.member.resp.PassengerQueryResp;

public interface PassengerService {

    void save(PassengerSaveReq req);

    PageResp<PassengerQueryResp> queryList(PassengerQueryReq req);

    void delete(Long id);
}
