package com.jyx.netty.parse;

import com.jyx.netty.command.Command;
import com.jyx.netty.command.CommandBuilder;
import com.jyx.netty.command.CommandFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @ClassName: Parser
 * @Description:
 * @Author: jyx
 * @Date: 2024-03-20 18:06
 **/
@Slf4j
@Component
public class Parser implements Parse<Command, String> {

    public Parser(CommandFactory commandFactory) {
        this.commandBuilder = commandFactory;
    }

    private CommandBuilder commandBuilder;

    @Override
    public synchronized Command parse(String message) {
        return commandBuilder.createUpriver(message);
    }
}
