package com.fanxin.train.business.service;

import com.fanxin.train.common.resp.PageResp;
import com.fanxin.train.business.req.DailyTrainTicketQueryReq;
import com.fanxin.train.business.req.DailyTrainTicketSaveReq;
import com.fanxin.train.business.resp.DailyTrainTicketQueryResp;

public interface DailyTrainTicketService {

    void save(DailyTrainTicketSaveReq req);

    PageResp<DailyTrainTicketQueryResp> queryList(DailyTrainTicketQueryReq req);

    void delete(Long id);
}