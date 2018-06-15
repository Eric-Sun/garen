package com.j13.garen.api.resp;

import com.j13.poppy.anno.Parameter;

public class AdminPainterOrderGetResp {
    @Parameter(desc = "order id")
    private int id;
    @Parameter(desc = "item's id")
    private int itemId;
    @Parameter(desc = "item's name")
    private String itemName;
    @Parameter(desc = "create time. formatted to timestamp")
    private long createtime;
    @Parameter(desc = "order status. see the fucking docs.")
    private int status;
    @Parameter(desc = "order uploaded img.")
    private String img;
    @Parameter(desc="")
    private String remark;
    @Parameter(desc="")
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

}
