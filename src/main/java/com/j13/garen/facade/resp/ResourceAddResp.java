package com.j13.garen.facade.resp;

import com.j13.garen.poppy.anno.Parameter;

public class ResourceAddResp {

    @Parameter(desc="resource id")
    private int resourceId;

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }
}
