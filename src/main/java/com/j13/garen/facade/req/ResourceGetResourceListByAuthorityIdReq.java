package com.j13.garen.facade.req;

import com.j13.garen.poppy.anno.Parameter;

public class ResourceGetResourceListByAuthorityIdReq {
    @Parameter(desc="auth id")
    private int authorityId;

    public int getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(int authorityId) {
        this.authorityId = authorityId;
    }
}
