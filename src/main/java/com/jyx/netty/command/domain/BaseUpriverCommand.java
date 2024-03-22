package com.jyx.netty.command.domain;

import com.jyx.netty.command.Command;
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
public abstract class BaseUpriverCommand implements Command {

    protected String commandType;

    protected String loraChannel;

    protected String addressGroup;

    protected String address;

    protected void buildHead(String message) {
        commandType = bits2String(message, 5);
        addressGroup = bits2String(message, 7);
        loraChannel = bits2String(message, 9);
        address = bits2String(message, 10, 6);
    }

    @Override
    public String commandType() {
        return this.commandType;
    }

    @Override
    public String address() {
        return this.address;
    }

    protected static String bits2String(String message, int index) {
        return bits2String(message, index - 1, 2);
    }

    protected static String bits2String(String message, int index, int offset) {
        return message.substring(index, index + offset);
    }

    protected static Integer bits2Int(String message, int index) {
        return Integer.parseInt(bits2String(message, index), 16);
    }
}
