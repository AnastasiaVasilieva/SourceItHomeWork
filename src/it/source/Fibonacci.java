package it.source;

import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {
        /*
        Выведите на экран первые 11 членов последовательности Фибоначчи.
        Напоминаем, что первый и второй члены последовательности равны единицам, а каждый следующий — сумме двух предыдущих.
        **/

        System.out.println(Arrays.deepToString(getFibonacciSeries(11)));
    }
    public static Integer[] getFibonacciSeries(int length) {
        Integer[] array = new Integer[length];
        array[0] = 1;
        array[1] = 1;
        for (int i = 2; i < array.length; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array;
    }

}
