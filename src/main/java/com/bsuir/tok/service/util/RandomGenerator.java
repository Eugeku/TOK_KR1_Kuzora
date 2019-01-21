package com.bsuir.tok.service.util;

import java.util.concurrent.ThreadLocalRandom;

public class RandomGenerator {

    /**
     * Method {@link #generateRandomInt(int, int)} generate random int from range
     *
     * @param left included left border
     * @param right excluded right border
     */
    public static int generateRandomInt(int left, int right) {
        return ThreadLocalRandom.current().nextInt(left, right);
    }
}
