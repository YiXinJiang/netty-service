package com.jyx.netty.event;

import com.jyx.netty.command.Command;

import java.lang.reflect.InvocationTargetException;

/**
 * @InterfaceName: EventPublish
 * @Description:
 * @Author: jyx
 * @Date: 2024-03-20 18:02
 **/
public interface EventService<T extends Command> {

    boolean publish(T command) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException;

}
