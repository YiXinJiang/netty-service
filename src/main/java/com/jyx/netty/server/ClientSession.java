package com.jyx.netty.server;

import io.netty.channel.Channel;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName: ChannelMap
 * @Description:
 * @Author: jyx
 * @Date: 2024-03-22 10:56
 **/
public class ClientSession {

    /**
     * 存放客户端标识与channel的对应关系
     */
    private static volatile ConcurrentHashMap<String, Channel> channelMap = null;

    private ClientSession() {
    }

    public static ConcurrentHashMap<String, Channel> getChannelMap() {
        if (null == channelMap) {
            synchronized (ClientSession.class) {
                if (null == channelMap) {
                    channelMap = new ConcurrentHashMap<>();
                }
            }
        }
        return channelMap;
    }

    public static Channel getChannel(String id) {
        return getChannelMap().get(id);
    }

}
