package com.bsuir.tok.controller;

import com.bsuir.tok.bean.CommandLineValues;
import com.bsuir.tok.command.exception.CommandException;
import com.bsuir.tok.command.iface.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("controller")
public class Controller {

    static final int minimalCountsParamInRequest = 1;

    @Autowired
    @Qualifier("commandProvider")
    private CommandProvider commandProvider;

    @Autowired
    @Qualifier("commandParser")
    private CommandParser commandParser;

    public Object executeRequest(String request) throws CommandException {
        String commandName;
        Command executionCommand;

        //        ArrayList<String> requestAfterParse = commandParser.parse(request);
        //        if (requestAfterParse.size() < minimalCountsParamInRequest) {
        //            return new WrongCommand().execute(request);
        //        }
        //        commandName = requestAfterParse.get(0);
        //        requestAfterParse.remove(0);
        //        executionCommand = commandProvider.getCommand(commandName);
        //        String[] stringsArray = new String[requestAfterParse.size()];
        //        stringsArray = requestAfterParse.toArray(stringsArray);
        //        Object resultOfExecuting = executionCommand.execute(stringsArray);
        //        return resultOfExecuting;

        CommandLineValues commandLineValues = commandParser.parse1(request);
        commandName = commandLineValues.getCommand();
        executionCommand = commandProvider.getCommand(commandName);
        String[] stringsArray = new String[2];
        stringsArray[0] = commandLineValues.getMessage();
        Object resultOfExecuting = executionCommand.execute(stringsArray);
        return resultOfExecuting;
    }
}
