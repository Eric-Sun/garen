package com.j13.garen.facade.resp;

import com.j13.garen.poppy.anno.Parameter;

public class AuthorityAddResp {

    @Parameter(desc="id")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}


