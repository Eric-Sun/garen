package com.j13.garen.api.req;

import com.j13.garen.poppy.anno.Parameter;

public class AccountDeleteReq {

    @Parameter(desc="id")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}