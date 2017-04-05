package com.j13.garen.facade.resp;

import com.j13.garen.poppy.anno.Parameter;

public class OrderGetResp {
    @Parameter(desc = "order id")
    private int orderId;
    @Parameter(desc = "user id")
    private int userId;
    @Parameter(desc = "user's name")
    private String userName;
    @Parameter(desc = "item's id")
    private int itemId;
    @Parameter(desc = "item's name")
    private String itemName;
    @Parameter(desc = "the final price")
    private float finalPrice;
    @Parameter(desc = "create time. formatted to timestamp")
    private long createtime;
    @Parameter(desc = "order status. see the fucking docs.")
    private int status;

    public long getCreatetime() {
        return createtime;
    }

    public void setCreatetime(long createtime) {
        this.createtime = createtime;
    }

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

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
