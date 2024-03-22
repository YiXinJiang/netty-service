package com.jyx.netty.event.domain;

import com.jyx.netty.command.Command;
import com.jyx.netty.event.BaseEvent;
import lombok.ToString;

/**
 * @ClassName: ParkLockStatus
 * @Description: 事件
 * @Author: jyx
 * @Date: 2024-03-21 14:13
 **/
@ToString(callSuper = true)
public class ReportParkLockStatusEvent extends BaseEvent<Command> {

    public ReportParkLockStatusEvent(Object source, Command eventData) {
        super(source, eventData);
    }
}
