package com.fanxin.train.business.service;

import com.fanxin.train.common.resp.PageResp;
import com.fanxin.train.business.req.StationQueryReq;
import com.fanxin.train.business.req.StationSaveReq;
import com.fanxin.train.business.resp.StationQueryResp;

public interface StationService {

    void save(StationSaveReq req);

    PageResp<StationQueryResp> queryList(StationQueryReq req);

    void delete(Long id);
}