package com.fanxin.train.business.service;

import com.fanxin.train.common.resp.PageResp;
import com.fanxin.train.business.req.TrainStationQueryReq;
import com.fanxin.train.business.req.TrainStationSaveReq;
import com.fanxin.train.business.resp.TrainStationQueryResp;

public interface TrainStationService {

    void save(TrainStationSaveReq req);

    PageResp<TrainStationQueryResp> queryList(TrainStationQueryReq req);

    void delete(Long id);
}