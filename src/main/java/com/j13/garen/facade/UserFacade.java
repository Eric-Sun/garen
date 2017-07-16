package com.j13.garen.facade;

import com.j13.garen.core.ErrorCode;
import com.j13.garen.daos.UserDAO;
import com.j13.garen.facade.req.UserCheckMobileReq;
import com.j13.garen.facade.req.UserLoginReq;
import com.j13.garen.facade.resp.UserLoginResp;
import com.j13.garen.poppy.core.CommonResultResp;
import com.j13.garen.poppy.util.BeanUtils;
import com.j13.garen.facade.req.UserRegisterReq;
import com.j13.garen.facade.resp.UserRegisterResp;
import com.j13.garen.poppy.anno.Action;
import com.j13.garen.poppy.core.CommandContext;
import com.j13.garen.poppy.exceptions.CommonException;
import com.j13.garen.utils.MD5Util;
import com.j13.garen.vos.UserVO;
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

    @Action(name = "user.login", desc = "用户登陆，密码需要md5，code=1001（密码错误）")
    public UserLoginResp login(CommandContext ctxt, UserLoginReq req) {
        UserLoginResp resp = new UserLoginResp();
        String mobile = req.getMobile();
        String passwordAfterMD5 = req.getPassword();
        UserVO vo = null;
        try {
            vo = userDAO.loginByMobile(mobile, passwordAfterMD5);
        } catch (EmptyResultDataAccessException e) {
            LOG.info("password error. mobile={},password={}", mobile, passwordAfterMD5);
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
    @Action(name = "user.register", desc = "用户注册,code=1002(手机号已经注册过)")
    public UserRegisterResp register(CommandContext ctxt, UserRegisterReq req) {
        UserRegisterResp resp = new UserRegisterResp();
        String mobile = req.getMobile();
        String password = req.getPassword();
//        String nickName = req.getNickName();
        // check mobile exists
        if (userDAO.mobileExisted(mobile)) {
            LOG.info("mobile existed. mobile={}", mobile);
            throw new CommonException(ErrorCode.User.MOBILE_EXISTED);
        }


        long id = userDAO.register(mobile, password);
        resp.setId(id);
        return resp;
    }


    @Action(name = "user.checkMobile", desc = "检查注册的手机号是否已经注册过了")
    public CommonResultResp checkMobile(CommandContext ctxt, UserCheckMobileReq req) {
        CommonResultResp resp = new CommonResultResp();
        String mobile = req.getMobile();
        if (userDAO.mobileExisted(mobile)) {
            LOG.info("mobile existed. mobile={}", mobile);
            throw new CommonException(ErrorCode.User.MOBILE_EXISTED);
        }
        return resp;
    }


}
