package com.jyx.netty;

import com.jyx.netty.server.BootNettyServer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.Async;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringNettyApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringNettyApplication.class, args);
    }

    @Async
    @Override
    public void run(String... args) throws Exception {
        /*
         * 异步启动netty服务端服务
         */
        new BootNettyServer().bind(8889);
    }

}
