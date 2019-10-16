package com.stylefeng.guns.api.film.vo;

/**
 * @Author: chensb
 * @Date: 2019/10/14 21:31
 */
import lombok.Data;

import java.io.Serializable;

/**
 * 影片演员信息
 */
@Data
public class ActorVO implements Serializable {

    private String imgAddress;
    private String directorName;
    private String roleName;

}
