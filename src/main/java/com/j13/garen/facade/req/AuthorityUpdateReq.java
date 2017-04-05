package com.j13.garen.facade.req;

import com.j13.garen.poppy.anno.Parameter;

public class AuthorityUpdateReq {
    @Parameter(desc="id")
    private int id;
    @Parameter(desc="name")
    private String name;
    @Parameter(desc="resource id array. as ['1','2']")
    private String resouceIdArray;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResouceIdArray() {
        return resouceIdArray;
    }

    public void setResouceIdArray(String resouceIdArray) {
        this.resouceIdArray = resouceIdArray;
    }
}
