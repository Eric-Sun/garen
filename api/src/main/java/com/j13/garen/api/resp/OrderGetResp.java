package com.j13.garen.api.resp;

import com.j13.garen.poppy.anno.Parameter;

public class OrderGetResp {
    @Parameter(desc = "order id")
    private int id;
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
    @Parameter(desc = "order uploaded img.")
    private String img;
    @Parameter(desc="user mobile")
    private String contactMobile;

    public String getContactMobile() {
        return contactMobile;
    }

    public void setContactMobile(String contactMobile) {
        this.contactMobile = contactMobile;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
