package com.jyx.netty.command.domain;

import com.jyx.netty.enums.Abnormal;
import com.jyx.netty.enums.LockStatus;
import com.jyx.netty.enums.VehicleInspect;
import com.jyx.netty.enums.VehicleInspectStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.function.Function;

/**
 * @ClassName: ReportParkingLockStatus
 * @Description: 锁状态上报
 * @Author: jyx
 * @Date: 2024-03-21 09:19
 **/
@Data
@SuperBuilder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ReportParkLockStatus extends BaseUpriverCommand {

    /**
     * 车检数据类型
     */
    private VehicleInspect vehicleInspectType;
    /**
     * 车检状态
     */
    private VehicleInspectStatus vehicleInspectStatus;
    /**
     * 锁状态
     */
    private LockStatus lockStatus;
    /**
     * 电池电压(实际电压x10)
     */
    private Integer batteryVoltage;
    /**
     * 异常状态
     */
    private Abnormal abnormal;
    /**
     * 4G信号强度(数值大于0x0C(12)，通信可靠)
     */
    private Integer RSSI4G;
    /**
     * 电池电量(百分比)
     */
    private Integer batteryPower;
    /**
     * 停车序列号
     */
    private Integer parkSerial;
    /**
     * 数据批次号
     */
    private Integer dataBatch;
    /**
     * 挡板倾斜角度
     */
    private Integer baffleAngle;

    public static Function<String, BaseUpriverCommand> creator = message -> {
        ReportParkLockStatus build = ReportParkLockStatus.builder()
                .vehicleInspectType(VehicleInspect.match(bits2String(message, 16, 1)))
                .vehicleInspectStatus(VehicleInspectStatus.match(bits2String(message, 17, 1)))
                .lockStatus(LockStatus.match(bits2String(message, 19)))
                .batteryVoltage(bits2Int(message, 21))
                .abnormal(Abnormal.match(bits2String(message, 23)))
                .RSSI4G(bits2Int(message, 25))
                .batteryPower(bits2Int(message, 27))
                .parkSerial(bits2Int(message, 29))
                .dataBatch(bits2Int(message, 31))
                .baffleAngle(bits2Int(message, 33))
                .build();
        build.buildHead(message);
        return build;
    };
}
