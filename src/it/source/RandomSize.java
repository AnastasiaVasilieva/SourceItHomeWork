package it.source;


public class RandomSize {
    public static void main(String[] args) {
        int[][] array = new int[5][(int) (Math.random() * 10)];
        print(Random(array));

    }
    public static void print(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            int[] array1 = array[i];
            for (int j = 0; j < array1.length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] Random(int[][] array){
        for (int i = 0; i < array.length; i++) {
            int[] array1 = array[i];
            for (int j = 0; j < array1.length; j++) {
                array[i][j] = (int) (Math.random() * 10);
            }
        }
        return array;
    }
}
