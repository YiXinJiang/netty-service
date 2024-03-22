package com.jyx.netty.server;

import com.jyx.netty.command.Command;
import com.jyx.netty.event.EventService;
import com.jyx.netty.parse.Parse;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.AttributeKey;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.net.InetSocketAddress;

/**
 * @ClassName: BootNettyChannelInboundHandlerAdapter
 * @Description:
 * @Author: jyx
 * @Date: 2024-03-20 15:16
 **/
@Slf4j
@Component
public class BootNettyChannelInboundHandlerAdapter extends ChannelInboundHandlerAdapter {

    private static BootNettyChannelInboundHandlerAdapter handler;
    private static final String sessionKey = "device_address";

    @PostConstruct
    public void init() {
        handler = this;
    }

    @Resource
    private Parse<Command, String> parse;
    @Resource
    private EventService<Command> eventService;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        log.info("channelRead:read msg: {}", msg.toString());
        Command command = handler.parse.parse(msg.toString());
        this.saveSession(ctx, command);
        boolean publish;
        try {
            publish = handler.eventService.publish(command);
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                 IllegalAccessException e) {
            publish = false;
            log.error("publish error: ", e);
        }
        if (!publish) {
            ctx.write("I got it, but exception during processing");
            return;
        }
        ctx.write("I got it");
    }

    private void saveSession(ChannelHandlerContext ctx, Command command) {
        ClientSession.getChannelMap().put(command.address(), ctx.channel());
        AttributeKey<String> key = AttributeKey.valueOf(sessionKey);
        ctx.channel().attr(key).setIfAbsent(command.address());
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        log.info("channel read complete");
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        log.info("exceptionCaught, {}", cause.getMessage());
        cause.printStackTrace();
        ctx.close(); // 抛出异常，断开与客户端的连接
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        ctx.channel().read();
        InetSocketAddress inSocket = (InetSocketAddress) ctx.channel().remoteAddress();
        String clientIp = inSocket.getAddress().getHostAddress();
        log.info("channelActive: {} + {}", clientIp, ctx.name());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
        InetSocketAddress inSocket = (InetSocketAddress) ctx.channel().remoteAddress();
        String clientIp = inSocket.getAddress().getHostAddress();
        ctx.close(); // 断开连接时，必须关闭，否则造成资源浪费，并发量很大情况下可能造成宕机
        this.removeSession(ctx);
        log.info("channelInactive: {}", clientIp);
    }

    private void removeSession(ChannelHandlerContext ctx) {
        AttributeKey<String> key = AttributeKey.valueOf(sessionKey);
        // 移除channel
        ClientSession.getChannelMap().remove(ctx.channel().attr(key).get());
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        super.userEventTriggered(ctx, evt);
        InetSocketAddress inSocket = (InetSocketAddress) ctx.channel().remoteAddress();
        String clientIp = inSocket.getAddress().getHostAddress();
        ctx.close(); // 超时时断开连接
        log.info("userEventTriggered: {}", clientIp);
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) {
        log.info("channelRegistered");

    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) {
        log.info("channelUnregistered");
    }

    @Override
    public void channelWritabilityChanged(ChannelHandlerContext ctx) {
        log.info("channel heritability changed");
    }

}
