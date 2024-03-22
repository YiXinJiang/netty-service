package com.jyx.netty.event;

import com.jyx.netty.command.Command;
import com.jyx.netty.command.domain.ReportICCID;
import com.jyx.netty.command.domain.ReportParkLockStatus;
import com.jyx.netty.event.domain.ReportCCIDEvent;
import com.jyx.netty.event.domain.ReportParkLockStatusEvent;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: EventFactory
 * @Description: 事件工厂 command to event
 * @Author: jyx
 * @Date: 2024-03-21 15:30
 **/
@Component
public class EventFactory {

    private Map<Class<?>, Class<?>> eventRegisterMap;

    @PostConstruct
    public void register() {
        eventRegisterMap = new HashMap<>();
        eventRegisterMap.put(ReportParkLockStatus.class, ReportParkLockStatusEvent.class);
        eventRegisterMap.put(ReportICCID.class, ReportCCIDEvent.class);
    }

    public Object buildEvent(Command command) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> aClass = eventRegisterMap.get(command.getClass());
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
        Constructor<?> declaredConstructor = declaredConstructors[0];
        return declaredConstructor.newInstance(this, command);
    }

}
