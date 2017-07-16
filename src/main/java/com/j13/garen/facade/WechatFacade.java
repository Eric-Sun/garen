package com.j13.garen.facade;

import com.google.common.collect.Lists;
import com.j13.garen.core.Constants;
import com.j13.garen.facade.req.WechatCheckTokenReq;
import com.j13.garen.poppy.anno.Action;
import com.j13.garen.poppy.core.CommandContext;
import com.j13.garen.poppy.util.EncryptionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;

@Component
public class WechatFacade {
    private static Logger LOG = LoggerFactory.getLogger(WechatFacade.class);


    @Action(name = "wechat.callback", desc = "check wechat token")
    public String checkToken(CommandContext ctxt, WechatCheckTokenReq req) {

        String signature = req.getSignature();
        String timestamp = req.getTimestamp();
        String nonce = req.getNonce();
        String echoStr = req.getEchostr();
        String token = Constants.Wechat.TOKEN;
        if (!StringUtils.isEmpty(ctxt.getPostData()))
            LOG.info("got post Data in callback function. {}", ctxt.getPostData());

        List<String> list = Lists.newArrayList();
        list.add(nonce);
        list.add(token);
        list.add(timestamp);
        Collections.sort(list);
        String e1 = EncryptionUtil.getSha1(list.get(0) + list.get(1) + list.get(2));

        if (e1.equals(signature))
            return echoStr;
        else {
            LOG.error("wechat check token error");
            return "";
        }
    }


}
