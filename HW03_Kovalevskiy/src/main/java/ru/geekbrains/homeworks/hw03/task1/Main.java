package ru.geekbrains.homeworks.hw03.task1;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    
    public static void main(String[] args) {
        log.info("Start program...");
        
        /* Первые 5 заданий делаю просто, без заморочек и тестов - т.к. времени не хватает, но без циклов! */

        // - 1 ---------------------------------------------------------------------------------------------------------
        int[] randomArray1 = new Random().ints(10, 0, 2).toArray();
        int[] resultArray1 = Arrays.stream(randomArray1).map(item -> (item == 0) ? 1 : 0).toArray();
        
        System.out.print("\nReplacing array elements:\n");
        System.out.println(Arrays.toString(randomArray1));
        System.out.println(Arrays.toString(resultArray1));
        
        // - 2 ---------------------------------------------------------------------------------------------------------
        int[] randomArray2 = IntStream.range(0, 101).toArray();
        
        System.out.print("\nFilling array:\n");
        System.out.println(Arrays.toString(randomArray2));
        
        // - 3 ---------------------------------------------------------------------------------------------------------
        int[] randomArray3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int[] resultArray3 = Arrays.stream(randomArray3).map(item -> (item < 6) ? item * 2 : item).toArray();
        
        System.out.print("\nMultiplying array elements:\n");
        System.out.println(Arrays.toString(randomArray3));
        System.out.println(Arrays.toString(resultArray3));

        // - 4 ---------------------------------------------------------------------------------------------------------
        /* Если есть варианты попроще, но без циклов - буду рад увидеть */
        System.out.print("\nFilling matrix:\n");
        AtomicInteger i = new AtomicInteger();
        int matrixLen = 10;
        Arrays.stream(new int[matrixLen][matrixLen])
                .map(item1 -> {
                    i.incrementAndGet();
                    AtomicInteger j = new AtomicInteger();
                    return Arrays.stream(item1)
                            .map(item2 -> {
                                j.incrementAndGet();
                                return ((i.get() == j.get()) || i.get() == (item1.length - j.get() + 1)) ? 1 : 0;
                            }).toArray();
                }).forEach(item -> System.out.println(Arrays.toString(item)));

        // - 5 ---------------------------------------------------------------------------------------------------------
        int len = 12, initialValue = -2;
        int[] resultArray5 = Arrays.stream(new int[len]).map(item -> initialValue).toArray();
    
        System.out.print("\nFilling array by default elements:\n");
        System.out.println(Arrays.toString(resultArray5));

        // - 6 ---------------------------------------------------------------------------------------------------------
        int[] randomArray6 = new Random().ints(10, -50, 50).toArray();
        System.out.print("\nChecking the extremum points of an array:\n");
        System.out.println(Arrays.toString(randomArray6));
        System.out.printf("Min element: %d\n", Main.getArrayMinElement(randomArray6));
        System.out.printf("Max element: %d\n", Main.getArrayMaxElement(randomArray6));
        
        // - 7 ---------------------------------------------------------------------------------------------------------
        int[] randomArray7 = new Random().ints(10, 1, 11).toArray();
        int halfSumElement = Main.getArrayHalfSumElementIndex(randomArray7);
        String halfSumResult = "There is no half-sum element!";
        
        if (halfSumElement > 0) {
            String leftHalf = Arrays.toString(Arrays.copyOfRange(randomArray7, 0, halfSumElement + 1));
            String rightHalf = Arrays.toString(Arrays.copyOfRange(randomArray7, halfSumElement + 1, randomArray7.length));
            halfSumResult = String.format("Half-sum data: %s:%s", leftHalf, rightHalf);
        }
        
        System.out.print("\nChecking for the presence of an array half-sum element:\n");
        System.out.printf("Start array: %s\n", Arrays.toString(randomArray7));
        System.out.println(halfSumResult);

        // - 8 ---------------------------------------------------------------------------------------------------------
        int shift1 = 3, shift2 = -4;
        int[] randomArray8 = new Random().ints(10, 1, 11).toArray();
        int[] shiftResult1 = Main.makeArrayShift(randomArray8, shift1);
        int[] shiftResult2 = Main.makeArrayShift(randomArray8, shift2);
        
        System.out.print("\nMaking N element shift of an array:\n");
        System.out.printf("Start array: %s\n", Arrays.toString(randomArray8));
        System.out.printf("Shifted [%d] array: %s\n", shift1, Arrays.toString(shiftResult1));
        System.out.printf("Shifted [%d] array: %s\n", shift2, Arrays.toString(shiftResult2));

        log.info("End program.\n");
    }
    
    /**
     * The method checks an array for null or empty
     *
     * @param data Array of integers
     */
    static void checkForNullEmpty(int[] data) {
        if (data == null) {
            log.error("Array is null! Can't handle null arrays!");
            throw new NullPointerException("Can't handle null arrays!");
        }
    
        if (data.length == 0) {
            log.error("Array is empty! Can't handle empty arrays!");
            throw new IllegalArgumentException("Can't handle empty arrays!");
        }
    }
    
    /**
     * The method finds the minimum element of an array
     *
     * @param data Array of integers
     * @return Minimum element of an array
     */
    //Arrays.stream(randomArray).min().orElse(0)
    static int getArrayMinElement(int[] data) {
        Main.checkForNullEmpty(data);
    
        log.info("Got an array: {}", Arrays.toString(data));
        
        int minElement = data[0];
        
        for (int i = 1; i < data.length; i++) {
            minElement = Math.min(data[i], minElement);
        }
        
        log.info("Got the minimum element of an array: {}", minElement);
        
        return minElement;
    }
    
    /**
     * The method finds the maximum element of an array
     *
     * @param data Array of integers
     * @return Maximum element of an array
     */
    //Arrays.stream(randomArray).max().orElse(0)
    static int getArrayMaxElement(int[] data) {
        Main.checkForNullEmpty(data);
    
        log.info("Got an array: {}", Arrays.toString(data));
        
        int maxElement = data[0];
    
        for (int i = 1; i < data.length; i++) {
            maxElement = Math.max(data[i], maxElement);
        }
    
        log.info("Got the maximum element of an array: {}", maxElement);
    
        return maxElement;
    }
    
    /**
     * The method checks the array for the presence of a half-sum element
     *
     * @param data Array of integers
     * @return Half-sum element index
     */
    static int getArrayHalfSumElementIndex(int[] data) {
        Main.checkForNullEmpty(data);
    
        log.info("Got an array: {}", Arrays.toString(data));
        
        int dataSum = Arrays.stream(data).sum();
        int halfSum = 0;
        int halfSumElement = -1;
        
        for (int i = 0; i < data.length; i++) {
            halfSum += data[i];
            
            if (halfSum * 2 == dataSum) {
                halfSumElement = i;
            }
        }
    
        log.info("Got a half-sum element index of the array: {}", halfSumElement);
        
        return halfSumElement;
    }
    
    /**
     * The method makes n element shift of an array
     *
     * @param data Array of integers
     * @return Shifted array
     */
    static int[] makeArrayShift(int[] data, int shift) {
        Main.checkForNullEmpty(data);
        
        // left the base array intact
        int[] newData = Arrays.copyOf(data, data.length);
        
        log.info("Got an array: {} will shift [{}] elements", Arrays.toString(newData), shift);
        
        int dataLength = newData.length - 1;
        
        if (shift > 0) {
            for (int i = 0; i < shift; i++) {
                int tmp = newData[dataLength];
                System.arraycopy(newData, 0, newData, 1, dataLength);
                newData[0] = tmp;
            }
        } else if (shift < 0) {
            for (int i = shift; i < 0; i++) {
                int tmp = newData[0];
                System.arraycopy(newData, 1, newData, 0, dataLength);
                newData[dataLength] = tmp;
            }
        }
        
        log.info("Got shifted array: {}", newData);
        
        return newData;
    }
}
