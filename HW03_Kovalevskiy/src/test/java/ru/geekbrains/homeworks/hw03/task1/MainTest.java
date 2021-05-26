package ru.geekbrains.homeworks.hw03.task1;

import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.geekbrains.homeworks.hw03.WatchmanExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Slf4j
@ExtendWith(WatchmanExtension.class)
public class MainTest {
    
    @Test
    public void when_ArrayIsNull_Expect_Exception() {
        assertThatThrownBy(() -> {
            log.info("Checking for exception:");
            Main.checkForNullEmpty(null);
        }).isInstanceOf(NullPointerException.class).hasMessage("Can't handle null arrays!");
    }
    
    @Test
    public void when_ArrayIsEmpty_Expect_Exception() {
        assertThatThrownBy(() -> {
            log.info("Checking for exception:");
            Main.checkForNullEmpty(new int[]{});
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("Can't handle empty arrays!");
    }
    
    @ParameterizedTest
    @MethodSource("ru.geekbrains.homeworks.hw03.task1.TestProviders#initMinMaxArrayProvider")
    public void when_ReturnMinimumElement_should_BeEqual(int[] checkedArray, int minElement, int maxElement) {
        log.info("Checking for minimum element: equal");
        assertThat(Main.getArrayMinElement(checkedArray)).isEqualTo(minElement);
    }
    
    @ParameterizedTest
    @MethodSource("ru.geekbrains.homeworks.hw03.task1.TestProviders#initMinMaxArrayProvider")
    public void when_ReturnMinimumElement_should_BeNotEqual(int[] checkedArray, int minElement, int maxElement) {
        log.info("Checking for minimum element: not equal");
        assertThat(Main.getArrayMinElement(checkedArray)).isNotEqualTo(maxElement);
    }
    
    @ParameterizedTest
    @MethodSource("ru.geekbrains.homeworks.hw03.task1.TestProviders#initMinMaxArrayProvider")
    public void when_ReturnMaximumElement_should_BeEqual(int[] checkedArray, int minElement, int maxElement) {
        log.info("Checking for maximum element: equal");
        assertThat(Main.getArrayMaxElement(checkedArray)).isEqualTo(maxElement);
    }
    
    @ParameterizedTest
    @MethodSource("ru.geekbrains.homeworks.hw03.task1.TestProviders#initMinMaxArrayProvider")
    public void when_ReturnMaximumElement_should_BeNotEqual(int[] checkedArray, int minElement, int maxElement) {
        log.info("Checking for maximum element: not equal");
        assertThat(Main.getArrayMaxElement(checkedArray)).isNotEqualTo(minElement);
    }
    
    @ParameterizedTest
    @MethodSource("ru.geekbrains.homeworks.hw03.task1.TestProviders#initHalfSumElementArrayProvider")
    public void when_ReturnHalfSumElement_should_BeEqual(int[] checkedArray, int rightIndex, int wrongIndex) {
        log.info("Checking for half-sum element existence: equal");
        assertThat(Main.getArrayHalfSumElementIndex(checkedArray)).isEqualTo(rightIndex);
    }
    
    @ParameterizedTest
    @MethodSource("ru.geekbrains.homeworks.hw03.task1.TestProviders#initHalfSumElementArrayProvider")
    public void when_ReturnHalfSumElement_should_BeNotEqual(int[] checkedArray, int rightIndex, int wrongIndex) {
        log.info("Checking for half-sum element existence: equal");
        assertThat(Main.getArrayHalfSumElementIndex(checkedArray)).isNotEqualTo(wrongIndex);
    }
    
    @ParameterizedTest
    @MethodSource("ru.geekbrains.homeworks.hw03.task1.TestProviders#initShiftArrayProvider")
    public void when_ReturnShiftedArray_should_BeEqual(int[] checkedArray, int shift, int[] rightResult) {
        log.info("Checking for half-sum element existence: equal");
        assertThat(Main.makeArrayShift(checkedArray, shift)).containsOnly(rightResult);
    }
}
