package com.jyx.netty;

import com.jyx.netty.service.MyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName: TestController
 * @Description:
 * @Author: jyx
 * @Date: 2024-03-22 15:58
 **/
@RestController
public class TestController {

    @Resource
    private MyService myService;

    @GetMapping("distribute")
    public void distribute() {
        myService.distribute();
    }

}
