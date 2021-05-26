package ru.geekbrains.homeworks.hw03.task1;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class TestProviders {
    
    static Stream<Arguments> initMinMaxArrayProvider() {
        return Stream.of(
                Arguments.of(new int[]{3, 2, 7, 2, 9, 1, 4}, 1, 9),
                Arguments.of(new int[]{13, -2, 7, 12, 9, 0, 4}, -2, 13),
                Arguments.of(new int[]{2, 6, 21, 0, 4, 1, 8}, 0, 21)
        );
    }
    
    static Stream<Arguments> initHalfSumElementArrayProvider() {
        return Stream.of(
                Arguments.of(new int[]{3, 2, 7, 2, 9, 1, 4}, 3, 0),
                Arguments.of(new int[]{2, 6, 21, 0, 4, 1, 8}, -1, 1),
                Arguments.of(new int[]{13, -2, 7, 12, 9, 0, -3}, 2, 5)
        );
    }
    
    static Stream<Arguments> initShiftArrayProvider() {
        return Stream.of(
                Arguments.of(new int[]{3, 2, 7, 2, 9, 1, 4}, 2, new int[]{1, 4, 3, 2, 7, 2, 9}),
                Arguments.of(new int[]{2, 6, 21, 0, 4, 1, 8}, 1, new int[]{8, 2, 6, 21, 0, 4, 1}),
                Arguments.of(new int[]{13, -2, 7, 12, 9, 0, -3}, -2, new int[]{7, 12, 9, 0, -3, 13, -2})
        );
    }
}
