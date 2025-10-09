package com.fanxin.train.member.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.ObjUtil;
import com.fanxin.train.common.req.MemberTicketReq;
import com.fanxin.train.common.resp.PageResp;
import com.fanxin.train.common.util.SnowUtil;
import com.fanxin.train.member.domain.Ticket;
import com.fanxin.train.member.domain.TicketExample;
import com.fanxin.train.member.mapper.TicketMapper;
import com.fanxin.train.member.req.TicketQueryReq;
import com.fanxin.train.member.resp.TicketQueryResp;
import com.fanxin.train.member.service.TicketService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    private static final Logger LOG = LoggerFactory.getLogger(TicketServiceImpl.class);

    @Resource
    private TicketMapper ticketMapper;

    /**
     * 会员购买车票后新增保存
     *
     * @param req
     */
    @Override
    public void save(MemberTicketReq req) throws Exception {
        DateTime now = DateTime.now();
        Ticket ticket = BeanUtil.copyProperties(req, Ticket.class);
        ticket.setId(SnowUtil.getSnowflakeNextId());
        ticket.setCreateTime(now);
        ticket.setUpdateTime(now);
        ticketMapper.insert(ticket);
    }

    @Override
    public PageResp<TicketQueryResp> queryList(TicketQueryReq req) {
        TicketExample ticketExample = new TicketExample();
        ticketExample.setOrderByClause("id desc");
        TicketExample.Criteria criteria = ticketExample.createCriteria();
        if (ObjUtil.isNotNull(req.getMemberId())) {
            criteria.andMemberIdEqualTo(req.getMemberId());
        }

        LOG.info("查询页码：{}", req.getPage());
        LOG.info("每页条数：{}", req.getSize());
        PageHelper.startPage(req.getPage(), req.getSize());
        List<Ticket> ticketList = ticketMapper.selectByExample(ticketExample);

        PageInfo<Ticket> pageInfo = new PageInfo<>(ticketList);
        LOG.info("总行数：{}", pageInfo.getTotal());
        LOG.info("总页数：{}", pageInfo.getPages());

        List<TicketQueryResp> list = BeanUtil.copyToList(ticketList, TicketQueryResp.class);

        PageResp<TicketQueryResp> pageResp = new PageResp<>();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(list);
        return pageResp;
    }

    @Override
    public void delete(Long id) {
        ticketMapper.deleteByPrimaryKey(id);
    }
}
