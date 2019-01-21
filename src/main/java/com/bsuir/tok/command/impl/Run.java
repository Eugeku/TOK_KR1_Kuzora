package com.bsuir.tok.command.impl;

import com.bsuir.tok.command.exception.CommandException;
import com.bsuir.tok.command.iface.Command;
import com.bsuir.tok.service.kr1.impl.Kr1Solution;
import com.bsuir.tok.service.util.ErrorGenerator;
import com.bsuir.tok.service.util.StringBitParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Run implements Command {

    @Autowired
    private Kr1Solution kr1Solution;

    @Override
    public Object execute(String... request) throws CommandException {
        String s = request[0];
        List<List<Integer>> arrayList = StringBitParser.stringToBitArray(s);
        System.out.println(arrayList);
        System.out.println(StringBitParser.bitArrayToString(arrayList));
        System.out.println(kr1Solution.encodeByAddingParityBit(arrayList).getEndecodedMessage());
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.set(i, ErrorGenerator.generateError(arrayList.get(i), ErrorGenerator.ErrorType.SINGLE));
        }
        System.out.println(kr1Solution.decodeByParityBit(arrayList).getParityExceptionList());
        System.out.println(StringBitParser.bitArrayToString(arrayList));
        return "end";
    }
}
