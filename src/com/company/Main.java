package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Выберите один из вариантов выполняемых задач:\n1. Вывод результата в одной симовльной строке" +
                "\n2. Программа, вычисляющая и выводящая на экран значение формулы: + - + - + " +
                "\n3. Размер ежемесячного дохода \nОтвет >> ");
        SwitchCh();

    }

    public static void SwitchCh() {
        Scanner sc = new Scanner(System.in);

        Main switchch = new Main();
        switch (sc.nextInt()) {
            case 1:
                switchch.printStr("One", "Two", "Three");
                break;
            case 2:
                switchch.FormulaPlusMinus(123.56789);
                break;
            case 3:
                System.out.println("Введите свой ежемесячный заработок >");
                switchch.Income(sc.nextInt());
                break;
            default:
                System.out.println("Нет такого пункта!\n try again\n>>");
                SwitchCh();
                break;
        }
    }

    public static void Income(int income) {
        if (income > 0 && income < 1000)
            System.out.println("критически малый доход");
        else if (income > 1000 && income < 5000)
            System.out.println("средний доход");
        else if (income > 5000 && income < 100000)
            System.out.println("высокий доход");
        else
            System.out.println("миллионер");
    }

    public static void FormulaPlusMinus(double n) {
        n *= 100000;
        int rez = 0;
        for (int i = 1; n != 0; i++) {
            if (i / 2 == 1) rez -= n % 10;
            else rez += n % 10;
            n /= 10;
        }
        System.out.println(rez);
    }

    public void printStr(String s1, String s2, String s3) {
        System.out.println(s1 + "/r/n" + s2 + "/r/n" + s3);
    }
}
