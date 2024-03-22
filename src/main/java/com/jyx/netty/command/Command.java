package com.jyx.netty.command;

/**
 * @InterfaceName: Command
 * @Description:
 * @Author: jyx
 * @Date: 2024-03-21 09:26
 **/
public interface Command {

    String commandType();

    String address();
}
