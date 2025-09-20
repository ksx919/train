package com.fanxin.train.${module}.service;

import com.fanxin.train.common.resp.PageResp;
import com.fanxin.train.${module}.req.${Domain}QueryReq;
import com.fanxin.train.${module}.req.${Domain}SaveReq;
import com.fanxin.train.${module}.resp.${Domain}QueryResp;

public interface ${Domain}Service {

    void save(${Domain}SaveReq req);

    PageResp<${Domain}QueryResp> queryList(${Domain}QueryReq req);

    void delete(Long id);
}