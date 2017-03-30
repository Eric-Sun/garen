package com.j13.v2.server.facade.resp;

import com.j13.v2.server.poppy.anno.Parameter;

public class FamilyAddResp {
    @Parameter(desc="家族id")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
