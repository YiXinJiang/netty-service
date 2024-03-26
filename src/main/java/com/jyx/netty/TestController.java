package com.jyx.netty;

import com.jyx.netty.domain.DistributeControl;
import com.jyx.netty.service.MyService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("distribute")
    public String distribute(@RequestBody DistributeControl distributeControl) {
        myService.distribute(distributeControl);
        return "accept command by post";
    }

    @GetMapping("distribute/{commandCode}")
    public String distribute(@PathVariable String commandCode) {
        myService.distribute(commandCode);
        return "accept command by get";
    }


}
