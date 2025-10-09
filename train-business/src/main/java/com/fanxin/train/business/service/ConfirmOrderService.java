package com.fanxin.train.business.service;

import com.fanxin.train.business.req.ConfirmOrderDoReq;
import com.fanxin.train.common.resp.PageResp;
import com.fanxin.train.business.req.ConfirmOrderQueryReq;
import com.fanxin.train.business.resp.ConfirmOrderQueryResp;

public interface ConfirmOrderService {

    void save(ConfirmOrderDoReq req);

    PageResp<ConfirmOrderQueryResp> queryList(ConfirmOrderQueryReq req);

    void delete(Long id);

    void doConfirm(ConfirmOrderDoReq req);
}