package com.jyx.netty.event;

import com.jyx.netty.command.Command;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;

/**
 * @ClassName: EventPublisher
 * @Description:
 * @Author: jyx
 * @Date: 2024-03-20 18:02
 **/
@Slf4j
@Component
public class EventPublisher implements EventService<Command> {

    @Resource
    private EventFactory eventFactory;
    @Resource
    private ApplicationEventPublisher publisher;

    @Override
    public boolean publish(Command command) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        log.info("command will be publish: {}", command);
        Object event = eventFactory.buildEvent(command);
        publisher.publishEvent(event);
        return true;
    }
}
