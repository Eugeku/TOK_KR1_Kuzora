package com.bsuir.tok.service.util;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringBitParser {

    public static List<List<Integer>> stringToBitArray(String string) {

        ArrayList<List<Integer>> arrayList = new ArrayList<>();

        // get bytes of each letter (example(ASCII): "foo" = {'f', 'o', 'o'} = {102, 111, 111})
        byte[] bytes = string.getBytes();

        // for each byte
        for (byte b : bytes) {

            // convert to simple char[] array: 102 ='1', '1', '0', '0', '1', '1', '0'
            char[] chars = Integer.toBinaryString(b).toCharArray();

            // convert to Character[]
            Character[] listOfCharAsObject = ArrayUtils.toObject(chars);

            // convert to ArrayList<Character>
            List<Character> arrayListOfChars = Arrays.asList(listOfCharAsObject);

            ArrayList<Integer> integerArray = new ArrayList<>();

            // magic with getting numeric equivalent of each bit
            for (int i = 0; i < arrayListOfChars.size(); i++) {
                char c = arrayListOfChars.get(i);
                integerArray.add(Character.getNumericValue(c));
            }
            arrayList.add(integerArray);
        }
        return arrayList;
    }

    public static String bitArrayToString(List<List<Integer>> bitArray) {

        StringBuffer stringToReturn = new StringBuffer();

        // calculate byte for getting char
        for (List<Integer> letter : bitArray) {
            byte b = 0;
            for (int i = 0; i < letter.size(); i++) {
                int integer = letter.get(i);
                b = (byte) (b + integer * Math.pow(2, (letter.size() - 1 - i)));
            }
            stringToReturn.append((char) b);
        }
        return stringToReturn.toString();
    }
}
