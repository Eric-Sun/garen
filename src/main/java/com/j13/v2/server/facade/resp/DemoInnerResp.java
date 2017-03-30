package com.j13.v2.server.facade.resp;

import com.j13.v2.server.poppy.anno.Parameter;

public class DemoInnerResp {

    @Parameter(desc="inner id")
    private int id;
    @Parameter(desc="inner name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
