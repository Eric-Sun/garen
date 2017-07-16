package com.j13.garen.api.req;

import com.j13.poppy.anno.Parameter;

public class OrderUpdateStatusReq {
    @Parameter(desc=" order id")
    private int orderId;
    @Parameter(desc=" order status. see the docs")
    private int status;

    @Parameter(desc="account id")
    private int accountId;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

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
