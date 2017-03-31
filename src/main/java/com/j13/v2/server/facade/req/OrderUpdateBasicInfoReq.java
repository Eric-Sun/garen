package com.j13.v2.server.facade.req;

import com.j13.v2.server.poppy.anno.Parameter;

public class OrderUpdateBasicInfoReq {
    @Parameter(desc = " order id")
    private int orderId;
    @Parameter(desc = "final price")
    private float finalPrice;
    @Parameter(desc=" item id")
    private int itemId;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public float getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(float finalPrice) {
        this.finalPrice = finalPrice;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

}
