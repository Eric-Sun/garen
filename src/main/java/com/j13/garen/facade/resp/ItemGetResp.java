package com.j13.garen.facade.resp;

import com.j13.garen.poppy.anno.Parameter;

public class ItemGetResp {
    @Parameter(desc="item's name")
    private String name;
    @Parameter(desc="item's id")
    private int itemId;
    @Parameter(desc="item's price")
    private float price;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
