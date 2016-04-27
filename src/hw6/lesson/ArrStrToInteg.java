package hw6.lesson;

import java.util.Arrays;

public class ArrStrToInteg {
    /**
     * Имеется массив String[] a, в котором хранятся числа. Требуется преобразовать его в двумерный массив int[][] c,
     * потом найдите сумму каждой цифры этих чисел.
     **/

    public static void main(String[] args) {

        String[] string = {"1 26 85", "89 265 86", "896 745 36"};
        Integer mas[][] = new Integer[3][3];

        for (int i = 0; i < 3; i++) {
            String s = string[i];
            String[] array = s.split(" ");
            Integer arq[] = new Integer[3];
            for (int q = 0; q < 3; q++) {
                mas[i][q] = Integer.parseInt(array[q]);
            }
        }
        System.out.println(Arrays.deepToString(mas));

        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < 3; k++) {
                int len = Integer.toString(mas[i][k]).length();
                String s = Integer.toString(mas[i][k]);
                char[] ch = s.toCharArray();
                int sum = 0;
                for (int j = 0; j < len; j++) {
                    sum += Character.getNumericValue(ch[j]);

                }
                System.out.print(sum + " ");
            }
        }

    }

}
