package com.fanxin.train.business.service;

import com.fanxin.train.common.resp.PageResp;
import com.fanxin.train.business.req.TrainSeatQueryReq;
import com.fanxin.train.business.req.TrainSeatSaveReq;
import com.fanxin.train.business.resp.TrainSeatQueryResp;

public interface TrainSeatService {

    void save(TrainSeatSaveReq req);

    PageResp<TrainSeatQueryResp> queryList(TrainSeatQueryReq req);

    void delete(Long id);

    void genTrainSeat(String trainCode);
}