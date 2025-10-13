package com.fanxin.train.business.service;

import com.fanxin.train.common.resp.PageResp;
import com.fanxin.train.business.req.DailyTrainStationQueryReq;
import com.fanxin.train.business.req.DailyTrainStationSaveReq;
import com.fanxin.train.business.resp.DailyTrainStationQueryResp;

import java.util.Date;

public interface DailyTrainStationService {

    void save(DailyTrainStationSaveReq req);

    PageResp<DailyTrainStationQueryResp> queryList(DailyTrainStationQueryReq req);

    void delete(Long id);

    void genDaily(Date date, String trainCode);

    long countByTrainCode(Date date, String trainCode);
}