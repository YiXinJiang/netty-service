package com.jyx.netty.command;

import com.jyx.netty.command.domain.*;
import com.jyx.netty.command.domain.*;
import com.jyx.netty.enums.DownriverCategory;
import com.jyx.netty.enums.UpriverCategory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @ClassName: CommandFactory
 * @Description: 指令工厂
 * @Author: jyx
 * @Date: 2024-03-21 17:53
 **/
@Component
public class CommandFactory implements CommandBuilder {

    private Map<UpriverCategory, Function<String, BaseUpriverCommand>> upriverMap;
    private Map<DownriverCategory, Function<DistributeCarrier, BaseDownriverCommand>> downriverMap;

    @PostConstruct
    public void register() {
        upriverMap = new HashMap<>();
        upriverMap.put(UpriverCategory.lock_status_report, ReportParkLockStatus.creator);
        upriverMap.put(UpriverCategory.iccid_report, ReportICCID.creator);

        downriverMap = new HashMap<>();
        downriverMap.put(DownriverCategory.query, DistributeQuery.creator);
    }

    @Override
    public BaseUpriverCommand createUpriver(String message) {
        UpriverCategory upriverCategory = this.matchCommandCategory(message);
        return upriverMap.get(upriverCategory).apply(message);
    }

    public String createDownriver(DistributeCarrier carrier) {
        return downriverMap.get(carrier.getCategory()).apply(carrier).commandContent();
    }

    private UpriverCategory matchCommandCategory(String message) {
        return UpriverCategory.match(message.substring(4, 6));
    }

}
