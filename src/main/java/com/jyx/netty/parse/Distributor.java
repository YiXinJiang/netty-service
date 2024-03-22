package com.jyx.netty.parse;

import com.jyx.netty.command.CommandBuilder;
import com.jyx.netty.command.DistributeCarrier;
import com.jyx.netty.server.ClientSession;
import io.netty.channel.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @ClassName: Distributor
 * @Description: 指令下发
 * @Author: jyx
 * @Date: 2024-03-22 15:44
 **/
@Slf4j
@Service
public class Distributor implements Distribute {

    @Resource
    private CommandBuilder commandBuilder;

    @Override
    public boolean distribute(DistributeCarrier carrier) {
        String message = commandBuilder.createDownriver(carrier);
        Channel channel = ClientSession.getChannel(carrier.getAddress());
        if (Objects.isNull(channel)) {
            log.error("device[{}] is offline", carrier.getAddress());
            throw new RuntimeException("client is offline");
        }
        log.info("distribute command to device[{}]: {}", carrier.getAddress(), message);
        channel.writeAndFlush(message);
        return true;
    }
}
