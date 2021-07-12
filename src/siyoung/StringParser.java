package siyoung;

import java.util.Arrays;
import java.util.List;

public class StringParser {

    public static List<String> split(String value, String delimiter) {
        return Arrays.asList(value.split(delimiter));
    }
}