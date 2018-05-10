package com.bsuir.tok.service.kr1.impl;

import com.bsuir.tok.service.kr1.exception.ParityException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ParityStorage {

    private List<ParityException> parityExceptionList = new ArrayList<>();

    private List<List<Integer>> encodecodedMessage;

    public List<ParityException> getParityExceptionList() {
        return parityExceptionList;
    }

    public void addItemToParityExceptionList(ParityException object) {
        parityExceptionList.add(object);
    }

    public List<List<Integer>> getEndecodedMessage() {
        return encodecodedMessage;
    }

    public void setEndecodedMessage(List<List<Integer>> endecodedMessage) {
        this.encodecodedMessage = endecodedMessage;
    }
}
