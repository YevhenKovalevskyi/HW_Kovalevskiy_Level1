package ru.geekbrains.homeworks.hw02.helpers;

/**
 * NumbersHelper Class is a helper class for different work with numbers
 *
 * @author e.kovalevskiy
 * @version 1.0
 */
public final class NumbersHelper {
    /**
     * The method determines whether a number belongs to a range
     *
     * @param x comparison number
     * @param lower lower end of range
     * @param upper upper end of range
     * @param isStrict strict mode
     * @return result of comparison
     */
    public static boolean isBetweenInterval(int x, int lower, int upper, boolean isStrict) {
        if (lower >= upper) {
            throw new IllegalArgumentException("Interval boundaries are incorrect!");
        }
        
        return isStrict ? lower < x && x < upper : lower <= x && x <= upper;
    }
    
    /**
     * The method determines whether the number is less than the boundary value.
     *
     * @param x comparison number
     * @param value boundary value
     * @param isStrict strict mode
     * @return result of comparison
     */
    public static boolean isLessThanNumber(int x, int value, boolean isStrict) {
        return isStrict ? x < value : x <= value;
    }
    
    /**
     * The method determines whether the number is more than the boundary value.
     *
     * @param x comparison number
     * @param value boundary value
     * @param isStrict strict mode
     * @return result of comparison
     */
    public static boolean isMoreThanNumber(int x, int value, boolean isStrict) {
        return isStrict ? x > value : x >= value;
    }
    
    /**
     * The method takes an integer and calculates factorial using recursion
     *
     * @param number integer
     * @return result of calculation
     */
    public static long factorial(int number) {
        return (number == 1) ? 1 : number * NumbersHelper.factorial(number - 1);
    }
    
    /**
     * The method takes an integer and checks its sign
     *
     * @param x integer
     * @return result of checking: [0 -neg, 1 - zero, 2 - pos]
     */
    public static int checkNumberSign(int x) {
        return 1 + (x >> 31) - (-x >> 31);
    }
}
