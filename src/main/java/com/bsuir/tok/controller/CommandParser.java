package com.bsuir.tok.controller;

import com.bsuir.tok.bean.CommandLineValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component("commandParser")
public class CommandParser {

    private static final String regExp = "[0-9A-Za-z-_.,]+";

    private static final String KR_PREFIX = "KR\\?version=([1-2])&command=(.*)&mesValue=([\\d\\D]*)";

    private static final String VERSION = "version=([1-2])";
    private static final String MESSAGE = "mesValue=(.*)";

    @Autowired
    private CommandLineValues commandLineValues;

    public ArrayList<String> parse(String request) {
        Matcher matcher = getMatcher(KR_PREFIX, request);
        if (matcher.find()) {
            commandLineValues.setVersion(Integer.parseInt(matcher.group(1)));
            commandLineValues.setCommand(matcher.group(2));
            commandLineValues.setMessage(matcher.group(3));
        }

        Pattern pattern = Pattern.compile(regExp);
        matcher = pattern.matcher(request);
        ArrayList<String> arrayList = new ArrayList<>();
        while (matcher.find()) {
            arrayList.add(matcher.group());
        }
        return arrayList;
    }

    private Matcher getMatcher(String regExp, String request) {
        Pattern pattern = Pattern.compile(regExp);
        return pattern.matcher(request);
    }

    public CommandLineValues parse1(String request) {
        Matcher matcher = getMatcher(KR_PREFIX, request);
        if (matcher.find()) {
            commandLineValues.setVersion(Integer.parseInt(matcher.group(1)));
            commandLineValues.setCommand(matcher.group(2));
            commandLineValues.setMessage(matcher.group(3));
        }
        return commandLineValues;
    }
}
