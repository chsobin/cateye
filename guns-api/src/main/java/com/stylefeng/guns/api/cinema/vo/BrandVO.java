package com.stylefeng.guns.api.cinema.vo;

/**
 * @Author: chensb
 * @Date: 2019/10/17 7:42
 */
import lombok.Data;

import java.io.Serializable;

@Data
public class BrandVO implements Serializable {

    // 主键编号
    private String brandId;
    // 显示名称
    private String brandName;
    // 是否选中，默认不选中
    private boolean isActive = false;

}
