package com.bsuir.tok.command.impl;

import com.bsuir.tok.bean.Config;
import com.bsuir.tok.command.exception.CommandException;
import com.bsuir.tok.command.iface.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Info implements Command {

    @Autowired
    private Config config;

    @Override
    public Object execute(String... request) throws CommandException {
        return config.toString();
    }
}
