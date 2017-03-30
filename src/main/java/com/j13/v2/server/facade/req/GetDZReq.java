package com.j13.v2.server.facade.req;

import com.j13.v2.server.poppy.anno.Parameter;

public class GetDZReq {
    @Parameter(desc = "段子的Id")
    private int dzId;

    public int getDzId() {
        return dzId;
    }

    public void setDzId(int dzId) {
        this.dzId = dzId;
    }
}
