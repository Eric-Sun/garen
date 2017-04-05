package com.j13.garen.poppy.util;

import com.j13.garen.poppy.exceptions.CommonException;
import com.j13.garen.core.ErrorCode;

import java.util.List;

public class BeanUtils {

    public static void copyProperties(Object dest, Object origin) {
        try {
            org.apache.commons.beanutils.BeanUtils.copyProperties(dest, origin);
        } catch (Exception e) {
            throw new CommonException(ErrorCode.System.REFLECT_ERROR);
        }
    }

}
