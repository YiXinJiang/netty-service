package com.jyx.netty.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

/**
 * @ClassName: CommandCategory
 * @Description:
 * @Author: jyx
 * @Date: 2024-03-21 17:55
 **/
@AllArgsConstructor
public enum UpriverCategory {

    /**
     * 锁状态上报
     */
    lock_status_report("01"),
    /**
     * ICCID 上报
     */
    iccid_report("03"),

    un_know("unKnow type"),
    ;

    @Getter
    private final String type;

    public static UpriverCategory match(String value) {
        Optional<UpriverCategory> first = Arrays.stream(UpriverCategory.values())
                .filter(UpriverCategory -> Objects.equals(UpriverCategory.type, value))
                .findFirst();
        return first.orElse(UpriverCategory.un_know);
    }
}
