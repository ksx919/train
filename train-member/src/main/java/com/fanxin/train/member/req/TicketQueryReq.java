package com.fanxin.train.member.req;

import com.fanxin.train.common.req.PageReq;
import lombok.Data;

@Data
public class TicketQueryReq extends PageReq {
    private Long memberId;
}
