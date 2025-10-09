package com.fanxin.train.business.service;

import com.fanxin.train.business.domain.DailyTrainCarriage;
import com.fanxin.train.common.resp.PageResp;
import com.fanxin.train.business.req.DailyTrainCarriageQueryReq;
import com.fanxin.train.business.req.DailyTrainCarriageSaveReq;
import com.fanxin.train.business.resp.DailyTrainCarriageQueryResp;

import java.util.Date;
import java.util.List;

public interface DailyTrainCarriageService {

    void save(DailyTrainCarriageSaveReq req);

    PageResp<DailyTrainCarriageQueryResp> queryList(DailyTrainCarriageQueryReq req);

    void delete(Long id);

    void genDaily(Date date, String trainCode);

    List<DailyTrainCarriage> selectBySeatType (Date date, String trainCode, String seatType);
}