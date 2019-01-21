package com.bsuir.tok.service.kr1.impl;

import com.bsuir.tok.service.kr1.exception.ParityException;
import com.bsuir.tok.service.kr1.iface.ParityDecodable;
import com.bsuir.tok.service.kr1.iface.ParityEncodable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Kr1Solution implements ParityEncodable, ParityDecodable {

    @Autowired
    private ParityStorage parityStorage;

    @Override
    public ParityStorage encodeByAddingParityBit(List<List<Integer>> undecodedMessage) {
        for (List<Integer> letterEncodingList : undecodedMessage) {
            int countOf1Bits = 0;
            for (Integer bit : letterEncodingList) {
                if (bit == 1) {
                    countOf1Bits++;
                }
            }
            if (countOf1Bits % 2 == 0) {
                letterEncodingList.add(0);
            } else {
                letterEncodingList.add(1);
            }
        }
        parityStorage.setEndecodedMessage(undecodedMessage);
        return parityStorage;
    }

    @Override
    public ParityStorage decodeByParityBit(List<List<Integer>> decodedMessage) {
        for (int i = 0; i < decodedMessage.size(); i++) {
            List<Integer> letterEncodingList = decodedMessage.get(i);
            int countOf1Bits = 0;
            for (Integer bit : letterEncodingList) {
                if (bit == 1) {
                    countOf1Bits++;
                }
            }
            if (countOf1Bits % 2 == 0) {
                letterEncodingList.remove(letterEncodingList.size() - 1);
            } else {
                parityStorage.addItemToParityExceptionList(new ParityException(
                    "Parity exception in letter list bits: " + letterEncodingList + ". " + "Sign position in message:"
                        + " " + i));
                letterEncodingList.remove(letterEncodingList.size() - 1);
            }
        }
        parityStorage.setEndecodedMessage(decodedMessage);
        return parityStorage;
    }
}
