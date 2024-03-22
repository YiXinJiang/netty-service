package com.jyx.netty.listener;

import com.jyx.netty.command.domain.ReportParkLockStatus;
import com.jyx.netty.service.MyService;
import com.jyx.netty.event.domain.ReportParkLockStatusEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @ClassName: ReportParkLockStatusEventListener
 * @Description:
 * @Author: jyx
 * @Date: 2024-03-21 15:06
 **/
@Slf4j
@Component
public class ReportParkLockStatusEventListener {

    @Resource
    private MyService myService;

    @EventListener
    public void handleReportParkLockStatusEvent(ReportParkLockStatusEvent event) {
        log.info("===> accept event of park lock status report:  {}", event);
        ReportParkLockStatus eventData = (ReportParkLockStatus) event.getEventData();
        // 业务处理....
        myService.process(eventData);
    }
}
