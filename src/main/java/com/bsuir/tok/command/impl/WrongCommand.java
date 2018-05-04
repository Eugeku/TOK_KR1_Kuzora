package com.bsuir.tok.command.impl;

import com.bsuir.tok.command.exception.CommandException;
import com.bsuir.tok.command.iface.Command;

public class WrongCommand extends Command {

    @Override
    public Object execute(String... request) throws CommandException {
        return null;
    }
}
