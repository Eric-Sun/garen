package com.j13.garen.facade.req;

import com.j13.garen.poppy.anno.Parameter;

public class ResourceGetReq {
    @Parameter(desc="get a resource")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
