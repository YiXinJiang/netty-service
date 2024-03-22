package com.jyx.netty.enums;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

/**
 * @EnumName: LockStatus
 * @Description:
 * @Author: jyx
 * @Date: 2024-03-21 11:11
 **/
@AllArgsConstructor
public enum LockStatus {

    /**
     * 升降中
     */
    motion("00"),
    /**
     * 正常升起
     */
    risen("10"),
    /**
     * 正常降下
     */
    descend("20"),
    /**
     * 降锁休眠
     */
    dormant_descend("22"),
    /**
     * 临时降锁休眠 (通信中断，通信恢复后需解除)
     */
    casual_dormant_descend("23"),
    /**
     * 升降遇阻后处于升起状态
     */
    risen_hover("1F"),
    /**
     * 升降遇阻后处于降下状态
     */
    descend_hover("2F"),
    /**
     * 异常
     */
    abnormal("FF"),

    un_know("unKnow type"),
    ;

    private final String type;

    public static LockStatus match(final String value) {
        Optional<LockStatus> first = Arrays.stream(LockStatus.values())
                .filter(LockStatus -> Objects.equals(LockStatus.type, value))
                .findFirst();
        return first.orElse(LockStatus.un_know);
    }


}
