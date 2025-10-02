package com.fanxin.train.business.controller.admin;;

import com.fanxin.train.common.context.LoginMemberContext;
import com.fanxin.train.common.resp.CommonResp;
import com.fanxin.train.common.resp.PageResp;
import com.fanxin.train.business.req.TrainSeatQueryReq;
import com.fanxin.train.business.req.TrainSeatSaveReq;
import com.fanxin.train.business.resp.TrainSeatQueryResp;
import com.fanxin.train.business.service.TrainSeatService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/train-seat")
public class TrainSeatAdminController {

  @Resource
  private TrainSeatService trainSeatService;

  @PostMapping("/save")
  public CommonResp<Object> save(@Valid @RequestBody TrainSeatSaveReq req) {
      trainSeatService.save(req);
      return new CommonResp<>();
  }

  @GetMapping("/query-list")
  public CommonResp<PageResp<TrainSeatQueryResp>> queryList(@Valid TrainSeatQueryReq req) {
      PageResp<TrainSeatQueryResp> list = trainSeatService.queryList(req);
      return new CommonResp<>(list);
  }

  @DeleteMapping("/delete/{id}")
  public CommonResp<Object> delete(@PathVariable Long id) {
      trainSeatService.delete(id);
      return new CommonResp<>();
  }
}