package com.j13.v2.server.facade.req;

import com.j13.v2.server.poppy.anno.Parameter;

public class OrderUpdateStatusReq {
    @Parameter(desc=" order id")
    private int orderId;
    @Parameter(desc=" order status. see the docs")
    private int status;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
