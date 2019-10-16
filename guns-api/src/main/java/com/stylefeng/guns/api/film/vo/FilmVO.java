package com.stylefeng.guns.api.film.vo;

/**
 * @Author: chensb
 * @Date: 2019/10/14 11:18
 */
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class FilmVO implements Serializable {

    private int filmNum;
    private int nowPage;
    private int totalPage;
    private List<FilmInfo> filmInfo;

}