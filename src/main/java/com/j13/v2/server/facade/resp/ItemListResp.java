package com.j13.v2.server.facade.resp;

import com.google.common.collect.Lists;
import com.j13.v2.server.poppy.anno.Parameter;

import java.util.List;

public class ItemListResp {

    @Parameter(desc="return item list.")
    private List<ItemGetResp> list = Lists.newLinkedList();

    public List<ItemGetResp> getList() {
        return list;
    }

    public void setList(List<ItemGetResp> list) {
        this.list = list;
    }
}
