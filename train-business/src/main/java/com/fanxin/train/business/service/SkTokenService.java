package com.fanxin.train.business.service;

import com.fanxin.train.business.req.SkTokenQueryReq;
import com.fanxin.train.business.req.SkTokenSaveReq;
import com.fanxin.train.business.resp.SkTokenQueryResp;
import com.fanxin.train.common.resp.PageResp;

import java.util.Date;

public interface SkTokenService {

    void genDaily(Date date, String trainCode);

    void save(SkTokenSaveReq req);

    PageResp<SkTokenQueryResp> queryList(SkTokenQueryReq req);

    void delete(Long id);

    boolean validSkToken(Date date, String trainCode, Long memberId);
}