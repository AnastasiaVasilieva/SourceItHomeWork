package it.source;

import java.util.Scanner;


public class Replace {

    public static void main(String[] args) {
        int[] array = {2, 3, 4, 1, 4, 5};
        print(array);
        System.out.println("");
        print(replaceNum(array));
    }

    public static int[] replaceNum(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int t = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = t;
        }
        return array;
    }

    public static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }


}
