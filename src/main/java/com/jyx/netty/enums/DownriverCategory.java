package com.jyx.netty.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @ClassName: CommandCategory
 * @Description:
 * @Author: jyx
 * @Date: 2024-03-21 17:55
 **/
@AllArgsConstructor
public enum DownriverCategory {

    /**
     * 查询
     */
    query("01"),
    /**
     * 控制
     */
    control("02"),
    /**
     * 特殊
     */
    special("03"),
    /**
     * 锁的心跳周期设置
     */
    heartbeat_cycle("F5"),
    /**
     * 挡板遇阻回调角度
     */
    obstruction_retrace("01"),
    /**
     * 挡板晃动预警参数(逃费预警)
     */
    shake_warn("02"),
    /**
     * 下行命令反馈使能
     */
    downriver_feedback_enable("03"),
    /**
     * 太阳能检查使能
     */
    solar_energy_check_enable("F5"),
    /**
     * 挡板上升到顶的角度设定
     */
    rise_utmost("01"),
    /**
     * 挡板上升到中间的遇阻判断角度设定
     */
    impeded_angle("02"),
    /**
     * 亮灯控制设定
     */
    light("03"),
    /**
     * 未知命令
     */
    un_know("FF"),
    ;

    @Getter
    private final String type;
}
