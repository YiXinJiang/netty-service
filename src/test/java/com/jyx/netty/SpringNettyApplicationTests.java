package com.jyx.netty;

import com.jyx.netty.service.MyService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SpringNettyApplicationTests {

    @Resource
    private MyService myService;

    @Test
    void contextLoads() {
        myService.distribute();
    }

}
