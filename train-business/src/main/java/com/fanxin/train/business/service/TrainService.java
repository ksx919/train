package com.fanxin.train.business.service;

import com.fanxin.train.common.resp.PageResp;
import com.fanxin.train.business.req.TrainQueryReq;
import com.fanxin.train.business.req.TrainSaveReq;
import com.fanxin.train.business.resp.TrainQueryResp;

import java.util.List;

public interface TrainService {

    void save(TrainSaveReq req);

    PageResp<TrainQueryResp> queryList(TrainQueryReq req);

    void delete(Long id);

    List<TrainQueryResp> queryAll();
}