package it.source;


import java.util.Arrays;
import java.util.Random;

public class RandomSize {
    /*
    *Создать двумерный массив из случайных чисел так
    *чтобы размер внутреннего массива был случайным. Вывести массив на экран.
    **/
    public static void main(String[] args) {

        Random random = new Random();
        int col = random.nextInt(10);
        Integer[][] array = new Integer[6][col];


        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = random.nextInt(10);
            }
        }
        System.out.println(Arrays.deepToString(array));


    }
}
