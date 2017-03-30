package com.j13.v2.server.poppy.util;

import com.j13.v2.server.poppy.exceptions.CommonException;
import com.j13.v2.server.core.ErrorCode;

public class BeanUtils {

    public static void copyProperties(Object dest, Object origin) {
        try {
            org.apache.commons.beanutils.BeanUtils.copyProperties(dest, origin);
        } catch (Exception e) {
            throw new CommonException(ErrorCode.System.REFLECT_ERROR);
        }
    }
}
