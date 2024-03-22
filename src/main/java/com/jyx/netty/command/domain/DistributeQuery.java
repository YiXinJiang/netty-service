package com.jyx.netty.command.domain;

import com.jyx.netty.command.DistributeCarrier;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.function.Function;

/**
 * @ClassName: DistributeQuery
 * @Description:
 * @Author: jyx
 * @Date: 2024-03-22 15:10
 **/
@Data
@SuperBuilder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class DistributeQuery extends BaseDownriverCommand {

    private String param;

    @Override
    protected void convert(DistributeCarrier carrier) {
        this.param = carrier.getParam() + "";
    }

    @Override
    protected String fillSuperParam() {
        return this.param;
    }

    public static Function<DistributeCarrier, BaseDownriverCommand> creator = carrier -> {
        DistributeQuery domain = DistributeQuery.builder().build();
        domain.convert(carrier);
        domain.build(carrier);
        return domain;
    };

}
