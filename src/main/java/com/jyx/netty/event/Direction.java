package com.jyx.netty.event;

import lombok.AllArgsConstructor;

/**
 * @ClassName: Direction
 * @Description: 上下行标识
 * @Author: jyx
 * @Date: 2024-03-20 18:08
 **/
@AllArgsConstructor
public enum Direction {

    /**
     * 上行
     */
    upriver,
    /**
     * 下行
     */
    downriver,
    /**
     * 未定义
     */
    undefined,
    ;

}
