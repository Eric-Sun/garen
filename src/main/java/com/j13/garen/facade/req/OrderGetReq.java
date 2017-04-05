package com.j13.garen.facade.req;

import com.j13.garen.poppy.anno.Parameter;

public class OrderGetReq {
    @Parameter(desc = "order id")
    private int orderId;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
