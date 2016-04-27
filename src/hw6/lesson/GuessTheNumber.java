package hw6.lesson;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    /**
     * Загадываем число от 0 до 100. У вас есть семь попыток на угадывание.
     * При каждой попытке будет выводиться сообщение - "Мало" или "Много".
     * Если угадаете, уложившись в семь попыток, то выиграли. Если нет, Выводим сообщение и снова загадываем и повторяем все снова
     **/
    public static void main(String[] args) {
        Game();
    }

    public static void Game() {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        int secretNumber = r.nextInt(100) + 1;
        System.out.println("Введите число >");

        for (int i = 0; i < 7; i++) {
            int yourNumber = sc.nextInt();
            if (yourNumber < secretNumber)
                System.out.println("Мало");
            if (yourNumber > secretNumber)
                System.out.println("Много");
            if (yourNumber == secretNumber) {
                System.out.println("Вы Выиграли!");
                return;
            }
        }
        System.out.println("Вы проиграли\nЗагадываем новое число");
        Game();
    }

}
