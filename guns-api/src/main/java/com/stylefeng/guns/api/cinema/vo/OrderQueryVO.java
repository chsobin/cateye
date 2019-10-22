package com.stylefeng.guns.api.cinema.vo;

/**
 * @Author: chensb
 * @Date: 2019/10/17 7:44
 */
import lombok.Data;

import java.io.Serializable;

@Data
public class OrderQueryVO implements Serializable {

    private String cinemaId;
    private String filmPrice;

}
