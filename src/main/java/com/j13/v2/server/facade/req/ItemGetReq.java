package com.j13.v2.server.facade.req;

import com.j13.v2.server.poppy.anno.Parameter;

public class ItemGetReq {
    @Parameter(desc="item id")
    private int itemId;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
}
