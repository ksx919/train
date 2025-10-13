package com.fanxin.train.business.service;

import com.fanxin.train.common.resp.PageResp;
import com.fanxin.train.business.req.SkTokenQueryReq;
import com.fanxin.train.business.req.SkTokenSaveReq;
import com.fanxin.train.business.resp.SkTokenQueryResp;

public interface SkTokenService {

    void save(SkTokenSaveReq req);

    PageResp<SkTokenQueryResp> queryList(SkTokenQueryReq req);

    void delete(Long id);
}