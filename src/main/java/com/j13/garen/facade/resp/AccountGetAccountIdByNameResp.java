package com.j13.garen.facade.resp;

import com.j13.garen.poppy.anno.Parameter;

public class AccountGetAccountIdByNameResp {
    @Parameter(desc="account id")
    private int accountId;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
}
