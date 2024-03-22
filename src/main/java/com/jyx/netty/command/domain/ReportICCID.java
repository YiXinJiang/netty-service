package com.jyx.netty.command.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.function.Function;

/**
 * @ClassName: ReportICCID
 * @Description:
 * @Author: jyx
 * @Date: 2024-03-21 17:55
 **/
@Data
@SuperBuilder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ReportICCID extends BaseUpriverCommand {

    private String markString;

    private String ICCID;

    public static Function<String, BaseUpriverCommand> creator = message -> {
        ReportICCID build = ReportICCID.builder()
                .markString(bits2String(message, 17, 5))
                .ICCID(bits2String(message, 23, 19))
                .build();
        build.buildHead(message);
        return build;
    };

}
