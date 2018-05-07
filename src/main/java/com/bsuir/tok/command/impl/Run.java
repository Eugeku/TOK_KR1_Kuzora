package com.bsuir.tok.command.impl;

import com.bsuir.tok.command.exception.CommandException;
import com.bsuir.tok.command.iface.Command;
import com.bsuir.tok.service.util.StringBitParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Run implements Command {

    @Autowired
    private StringBitParser parser;

    @Override
    public Object execute(String... request) throws CommandException {
        String s = request[0];
        List<List<Integer>> arrayList = parser.stringToBitArray(s);
        System.out.println(arrayList);
        System.out.println(parser.bitArrayToString(arrayList));
        return "end";
    }
}
