package com.j13.garen.facade;

import com.j13.garen.api.req.AdminPainterOrderListReq;
import com.j13.garen.api.req.OrderUpdateStatusReq;
import com.j13.garen.api.resp.AccountGetAuthorityByNameResp;
import com.j13.garen.api.resp.AdminPainterOrderGetResp;
import com.j13.garen.api.resp.AdminPainterOrderListResp;
import com.j13.garen.api.resp.OrderGetResp;
import com.j13.garen.core.Constants;
import com.j13.garen.daos.OrderDAO;
import com.j13.garen.vos.OrderVO;
import com.j13.poppy.anno.Action;
import com.j13.poppy.core.CommandContext;
import com.j13.poppy.core.CommonResultResp;
import com.j13.poppy.util.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 画家在后台的操作
 */
@Component
public class AdminPainterFacade {

    @Autowired
    OrderDAO orderDAO;


    @Action(name = "admin.painter.order.list", desc = "banner list.")
    public AdminPainterOrderListResp orderList(CommandContext ctxt,AdminPainterOrderListReq req){
        AdminPainterOrderListResp resp = new AdminPainterOrderListResp();
        List<OrderVO> list = null;
        if (req.getStatus() == Constants.OrderStatus.QUERY_ALL_STATUS) {
            list = orderDAO.list(req.getSizePerPage(), req.getPageNum());
        } else {
            list = orderDAO.list(req.getSizePerPage(), req.getPageNum(), req.getStatus());
        }
        for (OrderVO vo : list) {
            AdminPainterOrderGetResp r = new AdminPainterOrderGetResp();
            BeanUtils.copyProperties(r, vo);
            resp.getList().add(r);
        }
        return resp;
    }



    @Action(name = "admin.painter.order.updateStatus", desc = " update order's status")
    public CommonResultResp updateStatus(CommandContext ctxt, OrderUpdateStatusReq req) {
        CommonResultResp resp = new CommonResultResp();
        orderDAO.updateStatus(req.getOrderId(), req.getStatus());
        return resp;
    }


}
