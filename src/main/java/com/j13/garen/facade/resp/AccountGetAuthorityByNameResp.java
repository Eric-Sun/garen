package com.j13.garen.facade.resp;

import com.google.common.collect.Lists;
import com.j13.garen.poppy.anno.Parameter;

import java.util.List;

public class AccountGetAuthorityByNameResp {

    @Parameter(desc="resourceIdList")
    private List<Integer> resourceIdList = Lists.newLinkedList();

    public List<Integer> getResourceIdList() {
        return resourceIdList;
    }

    public void setResourceIdList(List<Integer> resourceIdList) {
        this.resourceIdList = resourceIdList;
    }
}
