package com.j13.v2.server.facade;

import com.j13.v2.server.core.ErrorCode;
import com.j13.v2.server.daos.UserDAO;
import com.j13.v2.server.facade.req.UserLoginReq;
import com.j13.v2.server.facade.req.UserRegisterReq;
import com.j13.v2.server.facade.resp.UserLoginResp;
import com.j13.v2.server.facade.resp.UserRegisterResp;
import com.j13.v2.server.poppy.anno.Action;
import com.j13.v2.server.poppy.core.CommandContext;
import com.j13.v2.server.poppy.exceptions.CommonException;
import com.j13.v2.server.poppy.util.BeanUtils;
import com.j13.v2.server.utils.MD5Util;
import com.j13.v2.server.vos.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 14-3-19
 * Time: 下午4:21
 * To change this template use File | Settings | File Templates.
 */
@Component
public class UserFacade {
    private static Logger LOG = LoggerFactory.getLogger(UserFacade.class);

    @Autowired
    UserDAO userDAO;


    @Action(name = "user.login", desc = "用户登陆")
    public UserLoginResp login(CommandContext ctxt, UserLoginReq req) {
        UserLoginResp resp = new UserLoginResp();
        String mobile = req.getMobile();
        String password = req.getPassword();
        String passwordAfterMD5 = MD5Util.getMD5String(password);
        UserVO vo = null;
        try {
            vo = userDAO.loginByMobile(mobile, passwordAfterMD5);
        } catch (EmptyResultDataAccessException e) {
            LOG.info("password error. mobile={},password={}", mobile, password);
            throw new CommonException(ErrorCode.User.PASSWORD_NOT_RIGHT);
        }

        BeanUtils.copyProperties(resp, vo);
        return resp;
    }


    /**
     * @return userId if registered successfully
     * -1 is mobile existed
     * -2 is nickName existed
     */
    @Action(name = "user.register", desc = "用户注册")
    public UserRegisterResp register(CommandContext ctxt, UserRegisterReq req) {
        UserRegisterResp resp = new UserRegisterResp();
        String mobile = req.getMobile();
        String password = req.getPassword();
        String nickName = req.getNickName();
        // check mobile exists
        if (userDAO.mobileExisted(mobile)) {
            LOG.info("mobile existed. mobile={}", mobile);
            throw new CommonException(ErrorCode.User.MOBILE_EXISTED);
        }

        // check nickName exists
        if (userDAO.nickNameExisted(nickName)) {
            LOG.info("nickname existed. nickname={}", nickName);
            throw new CommonException(ErrorCode.User.NICKNAME_EXISTED);
        }

        String passwordAfterMD5 = MD5Util.getMD5String(password);
        long id = userDAO.register(mobile, passwordAfterMD5, nickName);
        resp.setId(id);
        return resp;
    }


}
