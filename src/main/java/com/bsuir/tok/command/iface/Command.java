package com.bsuir.tok.command.iface;

import com.bsuir.tok.command.exception.CommandException;

public abstract class Command {

    public abstract Object execute(String... request) throws CommandException;
}
