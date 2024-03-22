package com.jyx.netty.enums;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.Optional;

/**
 * @EnumName: Abnormal
 * @Description: 异常状态
 * @Author: jyx
 * @Date: 2024-03-21 11:21
 **/
@AllArgsConstructor
public enum Abnormal {

    /**
     * 地磁传感器故障
     */
    geomagnetism(1),
    /**
     * 微波雷达故障
     */
    radar(2),
    /**
     * 角度传感器故障（角度传感器未连接或故障）
     */
    angle_sensor(2 << 1),
    /**
     * 探头通信故障（探头未连接或故障）
     */
    probe_communication(2 << 2),
    /**
     * 挡板升降遇阻报警
     */
    barrier_lifting_obstructed(2 << 3),
    /**
     * 挡板晃动报警（逃费报警）
     */
    baffle_shaking(2 << 4),
    /**
     * 挡板升降超时报警（电机未连接或故障）
     */
    baffle_lifting_timeout(2 << 5),
    /**
     * 挡板卡住，不能动报警（脚踩、砖块压、车轮压、卡车底、机械变形等）
     */
    blocked_baffle(2 << 6),
    /**
     * 未知状态
     */
    un_know(255),
    ;

    private final int code;

    public static Abnormal match(String msgCode) {
        int msgValue = Integer.parseInt(msgCode, 16);
        Optional<Abnormal> first = Arrays.stream(Abnormal.values()).filter(abnormal -> abnormal.code == msgValue).findFirst();
        return first.orElse(Abnormal.un_know);
    }

}
