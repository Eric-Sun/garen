package com.j13.garen.facade.resp;

import com.google.common.collect.Lists;
import com.j13.garen.poppy.anno.Parameter;

import java.util.List;

public class ResourceListResp {
    @Parameter(desc="resource list")
    private List<ResourceGetResp> list = Lists.newLinkedList();

    public List<ResourceGetResp> getList() {
        return list;
    }

    public void setList(List<ResourceGetResp> list) {
        this.list = list;
    }
}
