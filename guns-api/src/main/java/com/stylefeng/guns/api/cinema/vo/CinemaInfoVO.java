package com.stylefeng.guns.api.cinema.vo;

/**
 * @Author: chensb
 * @Date: 2019/10/17 7:42
 */
import lombok.Data;

import java.io.Serializable;

@Data
public class CinemaInfoVO implements Serializable {

    // 主键编号
    private String cinemaId;
    // 影院图片地址
    private String imgUrl;
    // 影院名称
    private String cinemaName;
    // 影院地址
    private String cinemaAddress;
    // 影院电话
    private String cinemaPhone;

}
