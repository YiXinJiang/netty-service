package com.jyx.netty.command.domain;

import com.jyx.netty.command.Command;
import com.jyx.netty.command.DistributeCarrier;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * @ClassName: BaseCommand
 * @Description:
 * @Author: jyx
 * @Date: 2024-03-21 09:09
 **/
@Data
@ToString
@SuperBuilder
public abstract class BaseDownriverCommand implements Command {

    /**
     * 帧起始
     */
    private final String frameStart = "EB90";
    /**
     * 帧结束
     */
    private final String frameEnd = "/r/n";
    /**
     * lora信道
     */
    private final String loraChannel = "00";
    /**
     * 设备地址
     */
    protected String address;
    /**
     * 指令类型
     */
    protected String commandType;
    /**
     * 指令全貌
     */
    private String commandContent;

    /**
     * 参数转换
     *
     * @return
     */
    protected abstract void convert(DistributeCarrier carrier);

    /**
     * 向父类传递转换后的参数
     *
     * @return
     */
    protected abstract String fillSuperParam();

    protected void build(DistributeCarrier carrier) {
        this.address = carrier.getAddress();
        this.commandType = carrier.getCategory().getType();
        this.commandContent = String.format("%s%s%s%s", frameStart, loraChannel, address, carrier.getCategory().getType());
        this.fillParam(fillSuperParam());
    }

    public String commandContent() {
        return this.commandContent;
    }

    public void fillParam(Object param) {
        // 填充参数 填充尾部 下行命令组装完毕
        this.commandContent = String.format("%s%s%s", commandContent, param, frameEnd);
    }

    @Override
    public String commandType() {
        return this.commandType;
    }

    @Override
    public String address() {
        return this.address;
    }

}
