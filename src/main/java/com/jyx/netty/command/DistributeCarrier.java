package com.jyx.netty.command;

import com.jyx.netty.enums.DownriverCategory;
import lombok.*;

/**
 * @ClassName: DistributeEvent
 * @Description:
 * @Author: jyx
 * @Date: 2024-03-22 15:15
 **/
@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DistributeCarrier {
    /**
     * 设备地址
     */
    private String address;
    /**
     * 指令码
     */
    private DownriverCategory category;
    /**
     * 指令参数
     */
    private Object param;
}
