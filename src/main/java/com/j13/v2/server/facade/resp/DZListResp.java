package com.j13.v2.server.facade.resp;

import com.google.common.collect.Lists;
import com.j13.v2.server.poppy.anno.Parameter;

import java.util.List;

public class DZListResp {

    @Parameter(desc = "数据")
    List<GetDZResp> data = Lists.newLinkedList();

    public List<GetDZResp> getData() {
        return data;
    }

    public void setData(List<GetDZResp> data) {
        this.data = data;
    }
}
