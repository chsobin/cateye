package com.stylefeng.guns.api.film.vo;

/**
 * @Author: chensb
 * @Date: 2019/10/14 21:31
 */
import lombok.Data;

import java.io.Serializable;

/**
 * 影片图片信息
 */
@Data
public class ImgVO implements Serializable {
    private String mainImg;
    private String img01;
    private String img02;
    private String img03;
    private String img04;
}