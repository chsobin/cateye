package com.stylefeng.guns.rest.modular.cinema.vo;

import com.stylefeng.guns.api.cinema.vo.CinemaInfoVO;
import com.stylefeng.guns.api.cinema.vo.FilmInfoVO;
import lombok.Data;

import java.util.List;

/**
 * @Author: chensb
 * @Date: 2019/10/19 8:12
 */

@Data
public class CinemaFieldsResponseVO {

    private CinemaInfoVO cinemaInfo;
    private List<FilmInfoVO> filmList;
}
