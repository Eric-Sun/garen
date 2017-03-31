package com.j13.v2.server.facade.req;

import com.j13.v2.server.poppy.anno.Parameter;

public class OrderAddReq {
    @Parameter(desc = "user id")
    private int userId;
    @Parameter(desc="item id")
    private int itemId;
    @Parameter(desc="final price. ")
    private float finalPrice;

    public float getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(float finalPrice) {
        this.finalPrice = finalPrice;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
