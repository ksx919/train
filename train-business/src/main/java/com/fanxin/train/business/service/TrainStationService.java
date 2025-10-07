package com.fanxin.train.business.service;

import com.fanxin.train.business.domain.TrainStation;
import com.fanxin.train.business.req.TrainStationQueryReq;
import com.fanxin.train.business.req.TrainStationSaveReq;
import com.fanxin.train.business.resp.TrainStationQueryResp;
import com.fanxin.train.common.resp.PageResp;

import java.util.List;

public interface TrainStationService {

    void save(TrainStationSaveReq req);

    PageResp<TrainStationQueryResp> queryList(TrainStationQueryReq req);

    void delete(Long id);

    List<TrainStation> selectByTrainCode(String trainCode);
}