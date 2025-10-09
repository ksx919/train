package com.fanxin.train.business.service;

import com.fanxin.train.business.domain.DailyTrainSeat;
import com.fanxin.train.business.domain.DailyTrainTicket;

import java.util.List;

public interface AfterConfirmOrderService {
    void afterDoConfirm(DailyTrainTicket dailyTrainTicket, List<DailyTrainSeat> finalSeatList);
}
