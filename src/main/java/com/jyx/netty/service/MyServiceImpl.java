package com.jyx.netty.service;

import com.jyx.netty.command.DistributeCarrier;
import com.jyx.netty.command.domain.ReportParkLockStatus;
import com.jyx.netty.domain.DistributeControl;
import com.jyx.netty.enums.DownriverCategory;
import com.jyx.netty.enums.DownriverParam;
import com.jyx.netty.event.domain.DistributeEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName: MyServiceImpl
 * @Description:
 * @Author: jyx
 * @Date: 2024-03-20 16:32
 **/
@Slf4j
@Service
public class MyServiceImpl implements MyService {

    @Resource
    private ApplicationEventPublisher publisher;

    @Override
    public String process(ReportParkLockStatus status) {
        log.info("service is processing");
        return "i got it";
    }

    @Override
    public void distribute(DistributeControl distributeControl) {
        DistributeCarrier carrier = DistributeCarrier.builder()
                .address("ADADAD")
                .category(DownriverCategory.query)
                .param(DownriverParam.query.value()).build();
        log.info("will distribute command: {}", carrier);
        DistributeEvent distributeEvent = new DistributeEvent(this, carrier);
        publisher.publishEvent(distributeEvent);
    }

    @Override
    public void distribute(String commandCode) {
        DistributeCarrier carrier = DistributeCarrier.builder()
                .address("ADADAD")
                .category(DownriverCategory.query)
                .param(DownriverParam.query.value()).build();
        log.info("will distribute command: {}", carrier);
        DistributeEvent distributeEvent = new DistributeEvent(this, carrier);
        publisher.publishEvent(distributeEvent);
    }

}
