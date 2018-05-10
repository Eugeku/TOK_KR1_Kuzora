package com.bsuir.tok.service.kr1.iface;

import com.bsuir.tok.service.kr1.impl.ParityStorage;

import java.util.List;

public interface ParityDecodable {

    ParityStorage decodeByParityBit(List<List<Integer>> decodedMessage);
}
