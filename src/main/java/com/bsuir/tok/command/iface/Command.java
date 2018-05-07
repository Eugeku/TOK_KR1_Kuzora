package com.bsuir.tok.command.iface;

import com.bsuir.tok.command.exception.CommandException;

public interface Command {

    Object execute(String... request) throws CommandException;
}
