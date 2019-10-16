package com.stylefeng.guns.api.film.vo;

/**
 * @Author: chensb
 * @Date: 2019/10/14 21:30
 */

import lombok.Data;

@Data
public class InfoRequestVO {

    private String biography;
    private ActorRequestVO actors;
    private ImgVO imgVO;
    private String filmId;

}
