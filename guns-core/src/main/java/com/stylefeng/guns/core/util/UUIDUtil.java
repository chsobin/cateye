package com.stylefeng.guns.core.util;

import java.util.UUID;

/**
 * @Author: chensb
 * @Date: 2019/10/23 19:21
 */
public class UUIDUtil {
    public static String genUuid(){
        return UUID.randomUUID().toString();
    }
}
