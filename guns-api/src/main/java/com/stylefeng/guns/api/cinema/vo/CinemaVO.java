package com.stylefeng.guns.api.cinema.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: chensb
 * @Date: 2019/10/17 7:35
 */
@Data
public class CinemaVO implements Serializable {

    // 主键编号
    private String uuid;
    // 影院名称
    private String cinemaName;
    // 影院地址
    private String address;
    // 最低票价
    private String minimumPrice;

}
