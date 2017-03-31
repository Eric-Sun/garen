package com.j13.v2.server.facade;

import com.j13.v2.server.core.Constants;
import com.j13.v2.server.daos.OrderDAO;
import com.j13.v2.server.facade.req.OrderAddReq;
import com.j13.v2.server.facade.req.OrderDeleteReq;
import com.j13.v2.server.facade.req.OrderUpdateBasicInfoReq;
import com.j13.v2.server.facade.req.OrderUpdateStatusReq;
import com.j13.v2.server.facade.resp.OrderAddResp;
import com.j13.v2.server.poppy.anno.Action;
import com.j13.v2.server.poppy.core.CommandContext;
import com.j13.v2.server.poppy.core.CommonResultResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderFacade {


    @Autowired
    OrderDAO orderDAO;

    @Action(name = "order.add", desc = "add an order by admin")
    public OrderAddResp add(CommandContext ctxt, OrderAddReq req) {
        OrderAddResp resp = new OrderAddResp();
        orderDAO.add(req.getUserId(), req.getItemId(), req.getFinalPrice(), Constants.OrderStatus.ORDER_CREATED);
        return resp;
    }

    @Action(name = "order.updateBasicInfo", desc = " update basic info of an order")
    public CommonResultResp updateBasicInfo(CommandContext ctxt, OrderUpdateBasicInfoReq req) {
        CommonResultResp resp = new CommonResultResp();
        orderDAO.updateBasicInfo(req.getOrderId(), req.getItemId(), req.getFinalPrice());
        return resp;
    }

    @Action(name = "order.updateStatus", desc = " update order's status")
    public CommonResultResp updateStatus(CommandContext ctxt, OrderUpdateStatusReq req) {
        CommonResultResp resp = new CommonResultResp();
        orderDAO.updateStatus(req.getOrderId(), req.getStatus());
        return resp;
    }

    @Action(name="order.delete",desc=" delete an order by orderId")
    public CommonResultResp delete(CommandContext ctxt, OrderDeleteReq req) {
        CommonResultResp resp = new CommonResultResp();
        orderDAO.delete(req.getOrderId());
        return resp;
    }



    public


}
