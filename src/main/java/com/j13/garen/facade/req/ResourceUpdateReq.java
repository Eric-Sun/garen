package com.j13.garen.facade.req;

import com.j13.garen.poppy.anno.Parameter;

public class ResourceUpdateReq {
    @Parameter(desc="resource id")
    private int id;
    @Parameter(desc="resource name")
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