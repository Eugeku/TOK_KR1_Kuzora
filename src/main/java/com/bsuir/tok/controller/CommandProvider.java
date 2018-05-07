package com.bsuir.tok.controller;

import com.bsuir.tok.command.exception.CommandException;
import com.bsuir.tok.command.iface.Command;
import com.bsuir.tok.command.impl.Info;
import com.bsuir.tok.command.impl.Run;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component("commandProvider")
public class CommandProvider {

    private Map<CommandName, Command> commandMap = new HashMap<>();

    @Autowired
    private CommandProvider(Run run, Info info) {
        commandMap.put(CommandName.RUN, run);
        commandMap.put(CommandName.INFO, info);
        commandMap.put(CommandName.HELP, info);
    }

    public Command getCommand(String stringCommand) throws CommandException {
        String com = stringCommand.replace("-", "_").toUpperCase();
        Command command;
        CommandName name = null;
        try {
            name = CommandName.valueOf(com);
            command = commandMap.get(name);
        } catch (IllegalArgumentException e) {
            throw new CommandException("Illegal command", e);
        }
        if (command == null) {
            throw new CommandException("Illegal command");
        }
        return command;
    }
}
