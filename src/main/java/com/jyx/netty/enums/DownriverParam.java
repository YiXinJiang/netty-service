package com.jyx.netty.enums;

import lombok.AllArgsConstructor;

/**
 * @EnumName: ControlParam
 * @Description: 指令参数枚举 囊括了一些可以用于枚举的参数 其余在命令实体中定义
 * @Author: jyx
 * @Date: 2024-03-22 14:00
 **/
@AllArgsConstructor
public enum DownriverParam {

    /**
     * 查询指令参数
     */
    query("01"),


    /**
     * 控制参数 - 复位
     */
    control_reset("33"),
    /**
     * 控制参数 - 升锁
     */
    control_rise("34"),
    /**
     * 控制参数 - 降锁
     */
    control_drop("35"),
    /**
     * 控制参数 - 降锁休眠
     */
    control_drop_sleep("06"),
    /**
     * 控制参数 - 灯闪烁
     */
    control_light_flicker("07"),
    /**
     * 控制参数 - 报警
     */
    control_warn("08"),
    /**
     * 控制参数 - 取消报警
     */
    control_cancel_warn("09"),


    /**
     * 特殊指令 - 重启车位锁
     */
    special_reset("12"),
    /**
     * 特殊 - 重新连接服务器
     */
    special_rise("14"),


    /**
     * 灯控制 - 关闭灯
     */
    light_control_reset("00"),
    /**
     * 灯控制 - 灯常亮
     */
    light_control_drop_sleep("FF"),

    ;
    private final String value;

    public String value() {
        return value;
    }

}
