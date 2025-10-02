package com.fanxin.train.business.controller.admin;;

import com.fanxin.train.common.context.LoginMemberContext;
import com.fanxin.train.common.resp.CommonResp;
import com.fanxin.train.common.resp.PageResp;
import com.fanxin.train.business.req.TrainQueryReq;
import com.fanxin.train.business.req.TrainSaveReq;
import com.fanxin.train.business.resp.TrainQueryResp;
import com.fanxin.train.business.service.TrainService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/train")
public class TrainAdminController {

  @Resource
  private TrainService trainService;

  @PostMapping("/save")
  public CommonResp<Object> save(@Valid @RequestBody TrainSaveReq req) {
      trainService.save(req);
      return new CommonResp<>();
  }

  @GetMapping("/query-list")
  public CommonResp<PageResp<TrainQueryResp>> queryList(@Valid TrainQueryReq req) {
      PageResp<TrainQueryResp> list = trainService.queryList(req);
      return new CommonResp<>(list);
  }

  @DeleteMapping("/delete/{id}")
  public CommonResp<Object> delete(@PathVariable Long id) {
      trainService.delete(id);
      return new CommonResp<>();
  }
}