package com.stylefeng.guns.api.film.vo;

/**
 * @Author: chensb
 * @Date: 2019/10/14 21:30
 */
import lombok.Data;

import java.util.List;

@Data
public class ActorRequestVO {

    private ActorVO director;
    private List<ActorVO> actors;

}