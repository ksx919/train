package com.fanxin.train.business.service;

import com.fanxin.train.business.req.DailyTrainQueryReq;
import com.fanxin.train.business.req.DailyTrainSaveReq;
import com.fanxin.train.business.resp.DailyTrainQueryResp;
import com.fanxin.train.common.resp.PageResp;

import java.util.Date;

public interface DailyTrainService {

    void save(DailyTrainSaveReq req);

    PageResp<DailyTrainQueryResp> queryList(DailyTrainQueryReq req);

    void delete(Long id);

    void genDaily(Date date);
}