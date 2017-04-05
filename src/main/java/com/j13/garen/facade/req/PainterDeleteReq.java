package com.j13.garen.facade.req;

import com.j13.garen.poppy.anno.Parameter;

public class PainterDeleteReq {
    @Parameter(desc="账号Id")
    private int accountId;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
}
