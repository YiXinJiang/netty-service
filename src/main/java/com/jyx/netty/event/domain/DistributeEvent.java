package com.jyx.netty.event.domain;

import com.jyx.netty.command.DistributeCarrier;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

import java.io.Serializable;

/**
 * @ClassName: DistributeEvent
 * @Description: 指令下发事件
 * @Author: jyx
 * @Date: 2024-03-22 15:40
 **/
@ToString(callSuper = true)
public class DistributeEvent extends ApplicationEvent implements Serializable {

    @Getter
    @Setter
    protected DistributeCarrier carrier;

    public DistributeEvent(Object source, DistributeCarrier carrier) {
        super(source);
        this.carrier = carrier;
    }
}
