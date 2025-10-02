package com.fanxin.train.business.service;

import com.fanxin.train.business.domain.TrainCarriage;
import com.fanxin.train.common.resp.PageResp;
import com.fanxin.train.business.req.TrainCarriageQueryReq;
import com.fanxin.train.business.req.TrainCarriageSaveReq;
import com.fanxin.train.business.resp.TrainCarriageQueryResp;

import java.util.List;

public interface TrainCarriageService {

    void save(TrainCarriageSaveReq req);

    PageResp<TrainCarriageQueryResp> queryList(TrainCarriageQueryReq req);

    void delete(Long id);

    List<TrainCarriage> selectByTrainCode(String trainCode);
}