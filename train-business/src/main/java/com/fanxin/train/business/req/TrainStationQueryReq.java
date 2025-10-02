package com.fanxin.train.business.req;

import com.fanxin.train.common.req.PageReq;
import lombok.Data;

@Data
public class TrainStationQueryReq extends PageReq {
    private String trainCode;
}
