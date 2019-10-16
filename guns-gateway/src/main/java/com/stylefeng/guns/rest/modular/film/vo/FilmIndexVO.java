package com.stylefeng.guns.rest.modular.film.vo;

/**
 * @Author: chensb
 * @Date: 2019/10/14 11:06
 */
import com.stylefeng.guns.api.film.vo.BannerVO;
import com.stylefeng.guns.api.film.vo.FilmInfo;
import com.stylefeng.guns.api.film.vo.FilmVO;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 首页信息
 */
@Data
public class FilmIndexVO implements Serializable {

    // 首页banners
    private List<BannerVO> banners;

    // 热门电影
    private FilmVO hotFilms;

    // 即将上映
    private FilmVO soonFilms;

    // 获取票房排行榜
    private List<FilmInfo> boxRanking;

    // 人气排行榜
    private List<FilmInfo> expectRanking;

    // 前100的影片排行
    private List<FilmInfo> top100;


}