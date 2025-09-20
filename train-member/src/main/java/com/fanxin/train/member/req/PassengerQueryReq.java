package com.fanxin.train.member.req;

import com.fanxin.train.common.req.PageReq;
import lombok.Data;

@Data
public class PassengerQueryReq extends PageReq {

    private Long MemberId;
}
