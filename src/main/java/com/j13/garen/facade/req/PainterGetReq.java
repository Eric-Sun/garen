package com.j13.garen.facade.req;

import com.j13.garen.poppy.anno.Parameter;

public class PainterGetReq {
    @Parameter(desc="账号id")
    private int accountId;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
}