package com.bsuir.tok.command.impl;

import com.bsuir.tok.command.exception.CommandException;
import com.bsuir.tok.command.iface.Command;
import com.bsuir.tok.service.kr1.impl.Kr1Solution;
import com.bsuir.tok.service.util.StringBitParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Run implements Command {

    @Autowired
    private StringBitParser parser;

    @Autowired
    private Kr1Solution kr1Solution;

    @Override
    public Object execute(String... request) throws CommandException {
        String s = request[0];
        List<List<Integer>> arrayList = parser.stringToBitArray(s);
        System.out.println(arrayList);
        System.out.println(parser.bitArrayToString(arrayList));
        System.out.println(kr1Solution.encodeByAddingParityBit(arrayList).getEndecodedMessage());
        arrayList.get(0).set(1,0);
        arrayList.get(5).set(2,1);
        System.out.println(kr1Solution.decodeByParityBit(arrayList).getParityExceptionList());
        System.out.println(parser.bitArrayToString(arrayList));
        return "end";
    }
}
