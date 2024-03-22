package com.jyx.netty.enums;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

/**
 * @EnumName: VehicleInspectStatus
 * @Description: 车检状态
 * @Author: jyx
 * @Date: 2024-03-21 11:08
 **/
@AllArgsConstructor
public enum VehicleInspectStatus {

    /**
     * 无车
     */
    busy("0"),
    /**
     * 有车
     */
    idle("1"),

    un_know("unKnow type"),
    ;

    private final String type;

    public static VehicleInspectStatus match(final String value) {
        Optional<VehicleInspectStatus> first = Arrays.stream(VehicleInspectStatus.values())
                .filter(VehicleInspectStatus -> Objects.equals(VehicleInspectStatus.type, value))
                .findFirst();
        return first.orElse(VehicleInspectStatus.un_know);
    }

}
