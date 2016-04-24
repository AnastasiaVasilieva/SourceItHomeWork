package it.source;

import java.util.Arrays;

public class ArrayMax {

    public static void main(String[] args) {

        int[] array = {2, 3, 4, 1, 2, 3, 5, 6, 7, 4, 1, 9, 9, 9, 9};
        System.out.println("kolMax = " + kolMaxValue(array));

    }

    public static int kolMaxValue(int array[]) {
        Arrays.sort(array);
        int kol = 0, max = array[array.length - 1];

        for (int i = 0; i < array.length; i++) {
            if (array[i] == max)
                kol++;
        }
        return kol;
    }
}


