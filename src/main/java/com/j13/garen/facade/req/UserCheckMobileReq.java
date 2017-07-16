package com.j13.garen.facade.req;

import com.j13.garen.poppy.anno.Parameter;

public class UserCheckMobileReq {
    @Parameter(desc="手机号")
    private String mobile;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
