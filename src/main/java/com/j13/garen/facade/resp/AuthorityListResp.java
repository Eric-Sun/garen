package com.j13.garen.facade.resp;

import com.google.common.collect.Lists;
import com.j13.garen.poppy.anno.Parameter;

import java.util.List;

public class AuthorityListResp {
    @Parameter(desc = "authority list")
    private List<AuthorityGetResp> list = Lists.newLinkedList();

    public List<AuthorityGetResp> getList() {
        return list;
    }

    public void setList(List<AuthorityGetResp> list) {
        this.list = list;
    }
}
