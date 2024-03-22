package com.jyx.netty.event;

import com.jyx.netty.command.Command;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

import java.io.Serializable;

/**
 * @ClassName: BaseEvent
 * @Description:
 * @Author: jyx
 * @Date: 2024-03-21 14:49
 **/
@ToString
public class BaseEvent<T extends Command> extends ApplicationEvent implements Serializable {

    @Getter
    @Setter
    protected T eventData;

    public BaseEvent(Object source, T eventData) {
        super(source);
        this.eventData = eventData;
    }
}
