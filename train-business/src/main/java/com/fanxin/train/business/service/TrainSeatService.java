package com.fanxin.train.business.service;

import com.fanxin.train.business.domain.TrainSeat;
import com.fanxin.train.common.resp.PageResp;
import com.fanxin.train.business.req.TrainSeatQueryReq;
import com.fanxin.train.business.req.TrainSeatSaveReq;
import com.fanxin.train.business.resp.TrainSeatQueryResp;

import java.util.List;

public interface TrainSeatService {

    void save(TrainSeatSaveReq req);

    PageResp<TrainSeatQueryResp> queryList(TrainSeatQueryReq req);

    void delete(Long id);

    void genTrainSeat(String trainCode);

    List<TrainSeat> selectByTrainCode(String trainCode);
}