package com.j13.garen.facade;

import com.alibaba.fastjson.JSON;
import com.j13.garen.daos.OrderActionLogDAO;
import com.j13.garen.daos.OrderDAO;
import com.j13.garen.api.req.*;
import com.j13.garen.api.resp.*;
import com.j13.garen.services.OrderNumberService;
import com.j13.poppy.core.CommonResultResp;
import com.j13.poppy.util.BeanUtils;
import com.j13.garen.core.Constants;
import com.j13.poppy.anno.Action;
import com.j13.poppy.core.CommandContext;
import com.j13.garen.services.ThumbService;
import com.j13.garen.vos.OrderVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderFacade {

    private static Logger LOG = LoggerFactory.getLogger(OrderFacade.class);

    @Autowired
    OrderDAO orderDAO;
    @Autowired
    ThumbService thumbService;
    @Autowired
    OrderNumberService orderNumberService;

    @Action(name = "order.add", desc = "add an order by admin")
    public OrderAddResp add(CommandContext ctxt, OrderAddReq req) {
        OrderAddResp resp = new OrderAddResp();
        // save the img
        String fileName = thumbService.uploadThumb(req.getImg());

        req.setImg(null);
        String orderNumber = orderNumberService.gen();

        int orderId = orderDAO.add(req.getUserId(), req.getItemId(),
                req.getFinalPrice(), Constants.OrderStatus.ORDER_CREATED, fileName, req.getRemark(), orderNumber);
        LOG.info("add order suc. id={}", orderId);
        resp.setOrderId(orderId);
        return resp;
    }

    @Action(name = "order.updateBasicInfo", desc = " update basic info of an order")
    public CommonResultResp updateBasicInfo(CommandContext ctxt, OrderUpdateBasicInfoReq req) {
        CommonResultResp resp = new CommonResultResp();
        if (req.getImg() == null) {
            orderDAO.updateBasicInfo(req.getOrderId(), req.getItemId(), req.getFinalPrice(), req.getContactMobile());
            LOG.info("update order suc. id={}", req.getOrderId());
        } else {
            String fileName = thumbService.uploadThumb(req.getImg());
            orderDAO.updateBasicInfo(req.getOrderId(), req.getItemId(), req.getFinalPrice(), fileName);
            LOG.info("update order suc. id={},fileName={}", req.getOrderId(), fileName);
        }

        return resp;
    }

    @Action(name = "order.updateStatus", desc = " update order's status")
    public CommonResultResp updateStatus(CommandContext ctxt, OrderUpdateStatusReq req) {
        CommonResultResp resp = new CommonResultResp();
        orderDAO.updateStatus(req.getOrderId(), req.getStatus());
        LOG.info("update order status suc. orderId={},status={}", req.getOrderId(), req.getStatus());
        return resp;
    }

    @Action(name = "order.delete", desc = " delete an order by orderId")
    public CommonResultResp delete(CommandContext ctxt, OrderDeleteReq req) {
        CommonResultResp resp = new CommonResultResp();
        orderDAO.delete(req.getOrderId());
        LOG.info("delete order .orderId={}", req.getOrderId());
        return resp;
    }

    @Action(name = "order.get", desc = "get a order by order ID")
    public OrderGetResp get(CommandContext ctxt, OrderGetReq req) {
        OrderGetResp resp = new OrderGetResp();
        OrderVO orderVO = orderDAO.get(req.getOrderId());
        BeanUtils.copyProperties(resp, orderVO);
        return resp;
    }

    @Action(name = "order.list", desc = "query order list.")
    public OrderListResp list(CommandContext ctxt, OrderListReq req) {
        OrderListResp resp = new OrderListResp();
        List<OrderVO> list = null;
        if (req.getStatus() == Constants.OrderStatus.QUERY_ALL_STATUS) {
            list = orderDAO.list(req.getSizePerPage(), req.getPageNum());
        } else {
            list = orderDAO.list(req.getSizePerPage(), req.getPageNum(), req.getStatus());
        }
        for (OrderVO vo : list) {
            OrderGetResp r = new OrderGetResp();
            BeanUtils.copyProperties(r, vo);
            resp.getList().add(r);
        }

        return resp;
    }


}