package com.fanxin.train.business.service;

import com.fanxin.train.business.req.DailyTrainSeatQueryReq;
import com.fanxin.train.business.req.DailyTrainSeatSaveReq;
import com.fanxin.train.business.resp.DailyTrainSeatQueryResp;
import com.fanxin.train.common.resp.PageResp;

import java.util.Date;

public interface DailyTrainSeatService {

    void save(DailyTrainSeatSaveReq req);

    PageResp<DailyTrainSeatQueryResp> queryList(DailyTrainSeatQueryReq req);

    void delete(Long id);

    void genDaily(Date date, String trainCode);
}