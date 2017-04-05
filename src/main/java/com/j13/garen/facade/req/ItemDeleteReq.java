package com.j13.garen.facade.req;

import com.j13.garen.poppy.anno.Parameter;

public class ItemDeleteReq {

    @Parameter(desc="商品id")
    private int itemId;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
}
