package com.bsuir.tok.controller;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component("commandParser")
public class CommandParser {
    private static final String regExp = "[0-9A-Za-z-_.,]+";

    public ArrayList<String> parse(String request) {
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(request);
        ArrayList<String> arrayList = new ArrayList<>();
        while (matcher.find()) {
            arrayList.add(matcher.group());
        }
        return arrayList;
    }
}
