package com.fanxin.train.business.controller.admin;;

import com.fanxin.train.common.context.LoginMemberContext;
import com.fanxin.train.common.resp.CommonResp;
import com.fanxin.train.common.resp.PageResp;
import com.fanxin.train.business.req.DailyTrainTicketQueryReq;
import com.fanxin.train.business.req.DailyTrainTicketSaveReq;
import com.fanxin.train.business.resp.DailyTrainTicketQueryResp;
import com.fanxin.train.business.service.DailyTrainTicketService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/daily-train-ticket")
public class DailyTrainTicketAdminController {

  @Resource
  private DailyTrainTicketService dailyTrainTicketService;

  @PostMapping("/save")
  public CommonResp<Object> save(@Valid @RequestBody DailyTrainTicketSaveReq req) {
      dailyTrainTicketService.save(req);
      return new CommonResp<>();
  }

  @GetMapping("/query-list")
  public CommonResp<PageResp<DailyTrainTicketQueryResp>> queryList(@Valid DailyTrainTicketQueryReq req) {
      PageResp<DailyTrainTicketQueryResp> list = dailyTrainTicketService.queryList(req);
      return new CommonResp<>(list);
  }

  @DeleteMapping("/delete/{id}")
  public CommonResp<Object> delete(@PathVariable Long id) {
      dailyTrainTicketService.delete(id);
      return new CommonResp<>();
  }
}