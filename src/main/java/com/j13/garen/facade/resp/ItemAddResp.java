package com.j13.garen.facade.resp;

import com.j13.garen.poppy.anno.Parameter;

public class ItemAddResp {

    @Parameter(desc="商品id")
    private int itemId;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
}