package com.fanxin.train.business.service;

import com.fanxin.train.business.domain.ConfirmOrder;
import com.fanxin.train.business.domain.DailyTrainSeat;
import com.fanxin.train.business.domain.DailyTrainTicket;
import com.fanxin.train.business.req.ConfirmOrderTicketReq;

import java.util.List;

public interface AfterConfirmOrderService {
    void afterDoConfirm(DailyTrainTicket dailyTrainTicket, List<DailyTrainSeat> finalSeatList,List<ConfirmOrderTicketReq> tickets, ConfirmOrder confirmOrder) throws Exception;
}
