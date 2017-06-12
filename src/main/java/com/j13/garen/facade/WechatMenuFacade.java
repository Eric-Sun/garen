package com.j13.garen.facade;

import com.j13.garen.facade.req.WechatMenuCreateReq;
import com.j13.garen.poppy.anno.Action;
import com.j13.garen.poppy.core.CommandContext;
import com.j13.garen.poppy.core.CommonResultResp;
import com.j13.garen.wx.WechatMenuManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WechatMenuFacade {

    @Autowired
    WechatMenuManager wechatMenuManager;

    @Action(name = "wechatMenu.create", desc = "")
    public CommonResultResp create(CommandContext ctxt, WechatMenuCreateReq req) {
        CommonResultResp resp = new CommonResultResp();
        String data = req.getData();
        wechatMenuManager.create(data);
        return resp;
    }






}
