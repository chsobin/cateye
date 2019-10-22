package com.stylefeng.guns.api.cinema.vo;

/**
 * @Author: chensb
 * @Date: 2019/10/17 7:44
 */
import lombok.Data;

import java.io.Serializable;

@Data
public class HallTypeVO implements Serializable {

    // 主键编号
    private String hallTypeId;
    // 显示名称
    private String hallTypeName;
    // 是否选中，默认不选中
    private boolean isActive;

}
