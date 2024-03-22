package com.jyx.netty.parse;

import com.jyx.netty.command.Command;

/**
 * @InterfaceName: Paese
 * @Description:
 * @Author: jyx
 * @Date: 2024-03-20 17:56
 **/
public interface Parse<T extends Command, String> {

    T parse(String message);

}
