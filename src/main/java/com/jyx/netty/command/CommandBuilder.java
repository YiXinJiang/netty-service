package com.jyx.netty.command;

import com.jyx.netty.command.domain.BaseUpriverCommand;

/**
 * @ClassName: CommandCreator
 * @Description:
 * @Author: jyx
 * @Date: 2024-03-22 09:27
 **/
public interface CommandBuilder {

    /**
     * 构建上行命令
     *
     * @param message 原始消息
     * @return
     */
    BaseUpriverCommand createUpriver(String message);

    /**
     * 构建下行命令
     *
     * @param carrier 指令运输实体
     * @return
     */
    String createDownriver(DistributeCarrier carrier);

}
