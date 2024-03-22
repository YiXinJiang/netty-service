package com.jyx.netty.parse;

import com.jyx.netty.command.DistributeCarrier;

/**
 * @InterfaceName: Distribute
 * @Description:
 * @Author: jyx
 * @Date: 2024-03-22 15:43
 **/
public interface Distribute {

    /**
     * 下发指令
     *
     * @param carrier
     * @return
     */
    boolean distribute(DistributeCarrier carrier);

}
