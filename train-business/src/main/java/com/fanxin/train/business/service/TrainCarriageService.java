package com.fanxin.train.business.service;

import com.fanxin.train.common.resp.PageResp;
import com.fanxin.train.business.req.TrainCarriageQueryReq;
import com.fanxin.train.business.req.TrainCarriageSaveReq;
import com.fanxin.train.business.resp.TrainCarriageQueryResp;

public interface TrainCarriageService {

    void save(TrainCarriageSaveReq req);

    PageResp<TrainCarriageQueryResp> queryList(TrainCarriageQueryReq req);

    void delete(Long id);
}