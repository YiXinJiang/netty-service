package com.jyx.netty.server;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @ClassName: BootNettyChannelInitializer
 * @Description:
 * @Author: jyx
 * @Date: 2024-03-20 15:16
 **/
public class BootNettyChannelInitializer extends ChannelInitializer<Channel> {

    @Override
    protected void initChannel(Channel ch) {
        // ChannelOutboundHandler，出站解析
        ch.pipeline().addLast("encoder", new StringEncoder());
        // 回车换行符分隔帧
        ch.pipeline().addLast(new LineBasedFrameDecoder(1024));
        // 属于ChannelInboundHandler，进站解析
        ch.pipeline().addLast("decoder", new StringDecoder());
        // 业务处理
        ch.pipeline().addLast(new BootNettyChannelInboundHandlerAdapter());
    }

}
