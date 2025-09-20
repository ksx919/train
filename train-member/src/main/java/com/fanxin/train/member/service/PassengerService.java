package com.fanxin.train.member.service;

import com.fanxin.train.member.req.PassengerQueryReq;
import com.fanxin.train.member.req.PassengerSaveReq;
import com.fanxin.train.member.resp.PassengerQueryResp;

import java.util.List;

public interface PassengerService {

    void save(PassengerSaveReq req);

    List<PassengerQueryResp> queryList(PassengerQueryReq req);
}
