package com.j13.garen.facade.resp;

import com.j13.garen.poppy.anno.Parameter;

public class AccountCheckExistedResp {
    @Parameter(desc = " true or false for existed")
    private boolean existed;

    public boolean isExisted() {
        return existed;
    }

    public void setExisted(boolean existed) {
        this.existed = existed;
    }
}
