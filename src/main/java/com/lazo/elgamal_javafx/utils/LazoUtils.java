package com.lazo.elgamal_javafx.utils;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Lazo on 2021-12-23
 * Created for <strong>Ministry of Internal Affairs</strong>
 */

public class LazoUtils {

    public static List<Character> convertStringToCharList(String str) {
        return str.chars().mapToObj(e -> (char)e).collect(Collectors.toList());
    }

    public static String toASCII(long value, int length) {
        StringBuilder builder = new StringBuilder(length);
        for (int i = length - 1; i >= 0; i--) {
            builder.append((char) ((value >> (8 * i)) & 0xFF));
        }
        return builder.toString();
    }


    public static long asciiArrayToLong(byte[] by) {

        long value = 0;
        for (byte b : by) {
            value = (value << 8) + (b & 0xff);
        }

        return value;
    }

    public static byte[] longToBytes(long x) {
        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
        buffer.putLong(x);
        return buffer.array();
    }

}
