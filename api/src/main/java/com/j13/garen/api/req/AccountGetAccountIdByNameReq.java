package com.j13.garen.api.req;

import com.j13.poppy.anno.Parameter;

public class AccountGetAccountIdByNameReq {
    @Parameter(desc="account name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
