package com.j13.garen.facade.resp;

import com.google.common.collect.Lists;
import com.j13.garen.poppy.anno.Parameter;

import java.util.List;

public class AccountListResp {
    @Parameter(desc="list")
    private List<AccountGetResp> list = Lists.newLinkedList();

    public List<AccountGetResp> getList() {
        return list;
    }

    public void setList(List<AccountGetResp> list) {
        this.list = list;
    }
}
