package com.stylefeng.guns.api.film;

import com.stylefeng.guns.api.film.vo.*;

import java.util.List;

/**
 * @Author: chensb
 * @Date: 2019/10/14 11:28
 */
public interface FilmServiceApi {

    // 获取首页banner
    List<BannerVO> getBanners();

    // 获取热门影片【受欢迎程度做排序】
    FilmVO getHotFilms(boolean isLimit, int nums, int nowPage, int sortId, int sourceId, int yearId, int catId);

    // 获取即将上映影片【受欢迎程度做排序】
    FilmVO getSoonFilms(boolean isLimit, int nums, int nowPage, int sortId, int sourceId, int yearId, int catId);

    // 获取经典影片【受欢迎程度做排序】
    FilmVO getClassicFilms(int nums, int nowPage, int sortId, int sourceId, int yearId, int catId);

    // 获取票房排行榜
    List<FilmInfo> getBoxRanking();

    // 获取人气排行榜
    List<FilmInfo> getExpectRanking();

    // 获取前100的影片
    List<FilmInfo> getTop();


    // ==== 获取影片条件接口
    // 获取分类条件
    List<CatVO> getCats();

    // 获取片源条件
    List<SourceVO> getSources();

    // 获取年代条件
    List<YearVO> getYears();


    // 根据影片ID或者名称获取影片信息
    FilmDetailVO getFilmDetail(int searchType, String searchParam);


    // 获取影片描述信息
    FilmDescVO getFilmDesc(String filmId);

    // 获取图片信息
    ImgVO getImgs(String filmId);

    // 获取导演信息
    ActorVO getDectInfo(String filmId);

    // 获取演员信息
    List<ActorVO> getActors(String filmId);


}
