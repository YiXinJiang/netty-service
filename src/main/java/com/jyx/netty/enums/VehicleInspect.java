package com.jyx.netty.enums;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

/**
 * @EnumName: VehicleInspect
 * @Description: 车检数据类型 总共会上报 0 A B C D E 3
 * 除 0 A 外平台无需关心其他状态
 * @Author: jyx
 * @Date: 2024-03-21 11:03
 **/
@AllArgsConstructor
public enum VehicleInspect {

    /**
     * 正常
     */
    normal("0"),
    /**
     * 心跳
     */
    heartbeat("A"),
    /**
     * 可忽略类型
     */
    ignore("ignore type"),
    ;

    private final String type;

    public static VehicleInspect match(final String value) {
        Optional<VehicleInspect> first = Arrays.stream(VehicleInspect.values())
                .filter(vehicleInspect -> Objects.equals(vehicleInspect.type, value))
                .findFirst();
        return first.orElse(VehicleInspect.ignore);
    }

}
