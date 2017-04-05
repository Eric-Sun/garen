package com.j13.garen.facade.req;

import com.j13.garen.poppy.anno.Parameter;

public class AccountGetAuthorityByNameReq {
    @Parameter(desc="account name.")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
