package it.source;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Replace {
    /*
    * Напишите программу, печатает массив, затем инвертирует
    * (то есть меняет местами первый элемент с последним, второй — с предпоследним и т.д.), и вновь печатает.
    **/
    public static void main(String[] args) {
        Random random = new Random();
        Integer[] array = new Integer[6];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10);
        }
        System.out.println(Arrays.deepToString(array));
        System.out.println(Arrays.deepToString(replaceNum(array)));
    }

    public static Integer[] replaceNum(Integer[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int t = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = t;
        }
        return array;
    }


}
