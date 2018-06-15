package com.j13.garen.api.req;

import com.j13.poppy.anno.Parameter;
import org.apache.commons.fileupload.FileItem;

public class OrderAddReq {
    @Parameter(desc = "user id")
    private int userId;
    @Parameter(desc = "item id")
    private int itemId;
    @Parameter(desc = "final price. ")
    private float finalPrice;
    @Parameter(desc = "")
    private FileItem img;
    @Parameter(desc = "")
    private String remark;
    @Parameter(desc = "")
    private String orderNumber;

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public FileItem getImg() {
        return img;
    }

    public void setImg(FileItem img) {
        this.img = img;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
