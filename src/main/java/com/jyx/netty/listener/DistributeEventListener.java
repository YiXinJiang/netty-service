package com.jyx.netty.listener;

import com.jyx.netty.event.domain.DistributeEvent;
import com.jyx.netty.parse.Distribute;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @ClassName: DistributeEventListener
 * @Description: 下行命令监听
 * @Author: jyx
 * @Date: 2024-03-22 15:38
 **/
@Slf4j
@Component
public class DistributeEventListener {

    @Resource
    private Distribute distribute;

    @EventListener
    public void handleReportParkLockStatusEvent(DistributeEvent event) {
        log.info("===> accept event of distribute:  {}", event);
        boolean distributeRes = distribute.distribute(event.getCarrier());
    }

}
