package com.bsuir.tok.service.util;

import com.mifmif.common.regex.Generex;

import java.util.List;
import java.util.stream.IntStream;

public class ErrorGenerator {

    private static final String REGEX = "[0-1]";

    public static List<Integer> generateError(List<Integer> bitArray, ErrorType errorType) {
        Generex generex = new Generex(REGEX);
        int bitArraySize = bitArray.size();
        switch (errorType) {
            case SINGLE:
                int randomNum = RandomGenerator.generateRandomInt(0, bitArraySize);
                bitArray.set(randomNum, Integer.parseInt(generex.random()));
                return bitArray;
            case CUSTOM:
                IntStream.range(0, errorType.getCount()).forEach(
                        i -> bitArray.set(
                                RandomGenerator.generateRandomInt(0, bitArraySize),
                                Integer.parseInt(generex.random())
                        )
                );
                return bitArray;
            case ANY:
                IntStream.range(0, bitArraySize).forEach(
                        i -> bitArray.set(i, Integer.parseInt(generex.random()))
                );
                return bitArray;
            case NONE:
            default:
                return bitArray;
        }
    }

    public enum ErrorType {
        SINGLE("One error in one message", 1),
        CUSTOM("Customize error"),
        ANY("Any error"),
        NONE("No errors");

        private Integer count;
        private String description;

        ErrorType(String description, Integer... count) {
            if (count.length != 0) {
                this.count = count[0];
            }
            this.description = description;
        }

        public String getDescription() {
            return description;
        }

        public Integer getCount() {
            return count;
        }

        public ErrorType setCount(Integer count) {
            this.count = count;
            return this;
        }
    }
}
