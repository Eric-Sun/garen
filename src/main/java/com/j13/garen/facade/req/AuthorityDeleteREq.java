package com.j13.garen.facade.req;

import com.j13.garen.poppy.anno.Parameter;

public class AuthorityDeleteReq {
    @Parameter(desc="id")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}