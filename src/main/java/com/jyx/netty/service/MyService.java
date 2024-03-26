package com.jyx.netty.service;

import com.jyx.netty.command.domain.ReportParkLockStatus;
import com.jyx.netty.domain.DistributeControl;

/**
 * @InterfaceName: MyService
 * @Description:
 * @Author: jyx
 * @Date: 2024-03-20 16:15
 **/
public interface MyService {

    String process(ReportParkLockStatus status);

    void distribute(DistributeControl distributeControl);

    void distribute(String commandCode);

}
