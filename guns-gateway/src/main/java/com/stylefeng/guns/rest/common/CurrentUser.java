package com.stylefeng.guns.rest.common;

import com.stylefeng.guns.api.user.vo.UserInfoModel;

/**
 * @Author: chensb
 * @Date: 2019/10/13 9:37
 */

/**
 * 工具类：用户信息管理
 */
public class CurrentUser {

    /**
     * 线程绑定的存储空间
     */
    private static ThreadLocal<UserInfoModel> userInfoThreadLocal = new ThreadLocal<>();

    /**
     * 将用户信息放入存储空间
     */
    public static void saveUserInfo(UserInfoModel userInfoModel) {
        userInfoThreadLocal.set(userInfoModel);
    }

    /**
     * 将用户信息取出
     */
    public static UserInfoModel getCurrentUser() {
        return userInfoThreadLocal.get();
    }


    /***********************************/
    /*
        如果存储用户信息，每个线程都需要开辟一定的空间用来存储，浪费内存，推荐存储用户id
        到ThreadLocal
     */

    private static ThreadLocal<String> userIdThreadLocal = new ThreadLocal<>();
    public static void saveUserId(String userId){
        userIdThreadLocal.set(userId);
    }
    public static String getCurrentUserId(){
        return userIdThreadLocal.get();
    }
}